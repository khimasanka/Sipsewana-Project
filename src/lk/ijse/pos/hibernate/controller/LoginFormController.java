package lk.ijse.pos.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author : kaveesha Himasanka
 * @since : 0.1.0
 **/
public class LoginFormController {

    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnLogin;
    public Label lblPassword;
    public Label lblUserName;
    public AnchorPane loginContext;

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
      /*  if (actionEvent.getSource() == btnLogin) {
            String username = txtUserName.getText();
            String password = txtPassword.getText();

            if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {*/
                Stage window =(Stage) loginContext.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/DashBoardForm.fxml")))));

            /*} else if (
                    txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()
            ) {
                ErrorStyle();
            } else {
                ErrorStyle();
            }
        }*/
    }

    public void ErrorStyle(){
        txtPassword.setStyle(" -fx-border-color: transparent transparent #f53f2b transparent");
        txtUserName.setStyle(" -fx-border-color: transparent transparent #f53f2b transparent");
        lblPassword.setStyle(" -fx-text-fill: #c50000");
        lblUserName.setStyle(" -fx-text-fill: #c50000");
    }
}
