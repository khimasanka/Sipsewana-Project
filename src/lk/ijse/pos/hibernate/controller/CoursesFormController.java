package lk.ijse.pos.hibernate.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.BOType;
import lk.ijse.pos.hibernate.bo.custom.CourseBO;
import lk.ijse.pos.hibernate.dto.CourseDTO;
import lk.ijse.pos.hibernate.view.tm.CourseTM;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CoursesFormController {
    public TableView<CourseTM> tblCourse;
    public TableColumn colPId;
    public TableColumn colProgram;
    public TableColumn colDuration;
    public TableColumn colFee;
    public TextField txtProgram;
    public TextField txtPId;
    public ComboBox<String> cmbDuration;
    public TextField txtFee;
    public Button btnSave;
    public Button btnUpdate;

    ObservableList<CourseTM> obList;
    CourseBO courseB0 = BOFactory.getInstance().getBO(BOType.COURSE);

    public void initialize() throws Exception {
        cmbDuration.getItems().addAll("6 Months", "1 Year", "2 Year");
        tblCourse.getItems().setAll(allCourses());

        colPId.setCellValueFactory(new PropertyValueFactory<>("pid"));
        colProgram.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

    }

    public ObservableList<CourseTM> allCourses(){
        try {
            List<CourseDTO> courses = courseB0.getAll();
            obList =FXCollections.observableArrayList();
            for (CourseDTO c : courses){
                obList.add(new CourseTM(
                        c.getProgramId(),
                        c.getName(),
                        c.getDuration(),
                        String.valueOf(c.getFee())
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obList;
    }

    public void saveProgramOnAction(ActionEvent actionEvent) throws Exception {
        try {
            if (courseB0.save(new CourseDTO(
                    txtPId.getText(),
                    txtProgram.getText(),
                    cmbDuration.getValue(),
                    Double.parseDouble(txtFee.getText())
            )));
            {
                new Alert(Alert.AlertType.CONFIRMATION,"Save Successful..").show();
                tblCourse.getItems().setAll(allCourses());
                clearFields();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Something went wrong. Please try again").show();
        }
    }



    public void updateProgramOnAction(ActionEvent actionEvent) throws Exception {
        try {
            if (courseB0.update(new CourseDTO(
                    txtPId.getText(),
                    txtProgram.getText(),
                    cmbDuration.getValue(),
                    Double.parseDouble(txtFee.getText())
            ))){
                new Alert(Alert.AlertType.CONFIRMATION,"Update Successful").show();
                clearFields();
                tblCourse.getItems().setAll(allCourses());
            } else {
                new Alert(Alert.AlertType.ERROR, "Something WEnt Wrong. Please Try Again!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something WEnt Wrong. Please Try Again!").show();
        }

    }

    public void deleteProgramOnAction(ActionEvent actionEvent) throws Exception {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete?", yes, no);

        alert.setTitle("Delete Confirmation");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.orElse(no) == yes) {
                courseB0.delete(txtPId.getText());
                tblCourse.getItems().setAll(allCourses());
                clearFields();
        }
    }

    private void clearFields(){
        txtPId.clear();
        txtFee.clear();
        txtProgram.clear();
    }

    public void searchCourse(ActionEvent actionEvent) throws Exception {
        CourseDTO i =courseB0.search(txtPId.getText());
        if (i==null){
            new Alert(Alert.AlertType.WARNING,"Empty Result").show();
        }else{
            txtProgram.setText(i.getName());
            txtFee.setText(String.valueOf(i.getFee()));
        }
    }
}
