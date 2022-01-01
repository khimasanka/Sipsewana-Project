package lk.ijse.pos.hibernate.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.pos.hibernate.bo.BOFactory;
import lk.ijse.pos.hibernate.bo.BOType;
import lk.ijse.pos.hibernate.bo.custom.StudentBO;
import lk.ijse.pos.hibernate.dao.custom.impl.StudentDAOImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class DashBoardFormController {
    public ImageView imgCourse;
    public ImageView imgStudent;
    public ImageView imgDetails;
    public Label lblCourse;
    public Label lblStudent;
    public Label lblDetails;
    public ImageView imgLogOut;
    public AnchorPane loadContext;
    public BorderPane root;
    public Label lblTitle;
    public Label lblDate;
    public Label lblTime;
    public Label lblStudentCount;

    StudentBO studentBO = BOFactory.getInstance().getBO(BOType.STUDENT);

    public void initialize() throws Exception {
        setContext("../view/CoursesForm.fxml");

        loadDateAndTime();

        lblStudentCount.setText(studentBO.studentCount());


        FadeTransition fadeIn = new FadeTransition(Duration.millis(500), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));

        final Thread thread = new Thread(()->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm aa ");
            while (true){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                final String times=simpleDateFormat.format(new Date());
                Platform.runLater(()->{
                    lblTime.setText(times);
                });
            }
        });
        thread.start();

    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblCourse.setText("");
            lblStudent.setText("");
            lblDetails.setText("");
        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            switch (icon.getId()) {
                case "imgCourse":
                    lblCourse.setText("Course");
                    break;
                case "imgStudent":
                    lblStudent.setText("Student");
                    break;
                case "imgDetails":
                    lblDetails.setText("Details");
                    break;
                case "imgLogOut":
                    break;
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    @FXML
    private void navigate(MouseEvent event) throws IOException {
        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgCourse":
                    setContext("../view/CoursesForm.fxml");
                    lblTitle.setText("Course");
                    break;
                case "imgStudent":
                    setContext("../view/StudentForm.fxml");
                    lblTitle.setText("Student");
                    break;
                case "imgDetails":
                    setContext("../view/DetailsForm.fxml");
                    lblTitle.setText("Details");
                    break;
                case "imgLogOut":
                    ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("No",ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                            "Are you sure you want to log out?",yes,no);
                    alert.setTitle("Log Out Confirmation");
                    Optional<ButtonType> result = alert.showAndWait();
                    if(result.orElse(no)==yes){
                        root= FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("../view/LoginForm.fxml")));
                    }
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
            }
        }
    }

    private void setContext(String root) {
        try {
            loadContext.getChildren().add(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(root))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
