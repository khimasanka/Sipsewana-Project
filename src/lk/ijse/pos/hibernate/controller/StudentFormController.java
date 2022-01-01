package lk.ijse.pos.hibernate.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.BOType;
import lk.ijse.pos.hibernate.bo.custom.CourseBO;
import lk.ijse.pos.hibernate.bo.custom.DetailsBO;
import lk.ijse.pos.hibernate.bo.custom.StudentBO;
import lk.ijse.pos.hibernate.dto.DetailsDTO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Course;
import lk.ijse.pos.hibernate.view.tm.StudentTM;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentFormController {
    public TableView<StudentTM> tblStudent;
    public TableColumn colSid;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colDOB;
    public TableColumn colNIC;
    public TableColumn colTelephone;
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtNIC;
    public TextField txtPhone;
    public Button btnUpdate;
    public Button btnDelete;
    public TableColumn colRegDate;
    public ComboBox cmbCourse;
    public Button btnAdd;
    public Button btnSave;
    public JFXDatePicker txtDOB;
    public Label regDate;
    public Label lblCourseName;
    public Label lblDuration;
    public Label lblFee;
    public AnchorPane courseContext;

    CourseBO courseB0 = BOFactory.getInstance().getBO(BOType.COURSE);
    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);
    DetailsBO detailsBO = BOFactory.getInstance().getBO(BOType.DETAILS);
    ObservableList<StudentTM> studentObList;


    public void initialize() throws Exception {
        loadCourseIds();
        tblStudent.getItems().setAll(allStudents());
        setCellValues();
        tblStudent.setVisible(true);
        courseContext.setVisible(false);

        txtId.setText(studentBO.generateSId());

        cmbCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                comboSelection(newValue);
            }
        });

    }

    public ObservableList<StudentTM> allStudents() {
        try {
            List<StudentDTO> student = studentBO.getAll();
            studentObList = FXCollections.observableArrayList();
            for (StudentDTO s : student) {
                studentObList.add(new StudentTM(
                        s.getsId(),
                        s.getName(),
                        s.getAddress(),
                        s.getDob(),
                        s.getNic(),
                        s.getPhone(),
                        s.getRegDate()
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentObList;
    }

    public void setCellValues() {
        colSid.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
        colNIC.setCellValueFactory(new PropertyValueFactory("nic"));
        colTelephone.setCellValueFactory(new PropertyValueFactory("phone"));
        colRegDate.setCellValueFactory(new PropertyValueFactory("regDate"));
    }

    public void updateStudentOnAction(ActionEvent actionEvent) {
        try {
            if (studentBO.update(new StudentDTO(
                    txtId.getText(),
                    txtName.getText(),
                    txtAddress.getText(),
                    String.valueOf(txtDOB.getValue()),
                    txtNIC.getText(),
                    txtPhone.getText(),
                    regDate.getText()
            ))) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Successful").show();
                tblStudent.getItems().setAll(allStudents());
            } else {
                new Alert(Alert.AlertType.ERROR, "Something WEnt Wrong. Please Try Again!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something WEnt Wrong. Please Try Again!").show();
        }
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) throws Exception {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete ?", yes, no);

        alert.setTitle("Delete Confirmation");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == yes) {
            studentBO.delete(txtId.getText());
            txtId.setText(studentBO.generateSId());
            tblStudent.getItems().setAll(allStudents());
        }
    }

    public void saveStudentOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO student = new StudentDTO(
                txtId.getText(),
                txtName.getText(),
                txtAddress.getText(),
                String.valueOf(txtDOB.getValue()),
                txtNIC.getText(),
                txtPhone.getText(),
                String.valueOf(Date.valueOf(LocalDate.now()))

        );
        if (studentBO.save(student)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Save Success").show();
            tblStudent.setVisible(true);
            tblStudent.getItems().setAll(allStudents());
            courseContext.setVisible(true);
            tblStudent.setVisible(false);
            txtAddress.setDisable(true);
            txtPhone.setDisable(true);
            txtNIC.setDisable(true);
            txtName.setDisable(true);
            txtDOB.setDisable(true);
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }
    }

    private void loadCourseIds() throws Exception {
        List<String> courses = courseB0.getCourseIds();
        cmbCourse.getItems().addAll(courses);
    }


    public void searchStudent(ActionEvent actionEvent) throws Exception {
        StudentDTO i = studentBO.search(txtId.getText());
        if (i == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        } else {
            txtName.setText(i.getName());
            txtAddress.setText(String.valueOf(i.getAddress()));
            txtDOB.setValue(LocalDate.parse(i.getDob()));
            txtNIC.setText(i.getNic());
            txtPhone.setText(i.getPhone());
            regDate.setText(i.getRegDate());
            tblStudent.setVisible(false);
            courseContext.setVisible(true);
        }
    }

    private void comboSelection(String s) {
        try {
            Course course = courseB0.search(s);
            lblCourseName.setText(course.getName());
            lblDuration.setText(course.getDuration());
            lblFee.setText(String.valueOf(course.getFee()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCourseDetails(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        boolean b = saveDetails(detailsBO.generateNewID(), txtId.getText(), String.valueOf(cmbCourse.getValue()),LocalDate.now());
        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION,"Success").show();
        }else{
            new Alert(Alert.AlertType.WARNING,"Something Went Wrong").show();
        }
    }

    public boolean saveDetails(String regId,String sId, String cId, LocalDate date) throws ClassNotFoundException {
        try {
            DetailsDTO registerDTO = new DetailsDTO(regId,sId,cId,date);
            return detailsBO.regDetails(registerDTO);

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
