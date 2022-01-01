package lk.ijse.pos.hibernate.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.BOType;
import lk.ijse.pos.hibernate.bo.custom.CourseBO;
import lk.ijse.pos.hibernate.bo.custom.DetailsBO;
import lk.ijse.pos.hibernate.dao.custom.impl.DetailsDAOImpl;
import lk.ijse.pos.hibernate.dao.custom.impl.QueryDAOImpl;
import lk.ijse.pos.hibernate.dto.CustomDTO;
import lk.ijse.pos.hibernate.dto.DetailsDTO;
import lk.ijse.pos.hibernate.dto.StudentDTO;
import lk.ijse.pos.hibernate.entity.Details;
import lk.ijse.pos.hibernate.view.tm.DetailsTM;
import lk.ijse.pos.hibernate.view.tm.StudentTM;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DetailsFormController {
    public TableView<DetailsTM> tblDetails;
    public TableColumn colRegId;
    public TableColumn colStudentId;
    public TableColumn colCourseId;
    public TableColumn ColSName;
    public TableColumn colRegDate;
    public TextField txtSearch;

    DetailsBO detailsBO = BOFactory.getInstance().getBO(BOType.DETAILS);
    ObservableList<DetailsTM> detailsTMS;
    public void initialize() {
        loadAllDetails();
    }

    public void searchDetailsOnAction(ActionEvent actionEvent) {

    }

    private void loadAllDetails() {
        QueryDAOImpl queryDAO = new QueryDAOImpl();
        ArrayList<CustomDTO> allDetails = queryDAO.getAll();
        for (CustomDTO detail : allDetails) {
            tblDetails.getItems().add(new DetailsTM(detail.getRegId(),detail.getsName(),detail.getsId(),detail.getpId(),detail.getRegDate()));
        }
    }

    public ObservableList<DetailsTM> allDetails() {
        try {
            QueryDAOImpl queryDAO = new QueryDAOImpl();
            ArrayList<CustomDTO> details = queryDAO.getAll();
            detailsTMS = FXCollections.observableArrayList();
            for (CustomDTO s : details) {
                detailsTMS.add(new DetailsTM(
                        s.getRegId(),
                        s.getsName(),
                        s.getsId(),
                        s.getpId(),
                        s.getRegDate()
                ));
                System.out.println(s.getsId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailsTMS;
    }

}
