package lk.ijse.pos.hibernate;/**
 * @author : Kaveesha Himasanka
 * @since : 0.1.0
 **/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.pos.hibernate.bo.custom.impl.DetailsBOImpl;
import lk.ijse.pos.hibernate.dto.DetailsDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("view/LoginForm.fxml")));
        primaryStage.setTitle("Sipsewana");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("lk/ijse/pos/hibernate/asserts/images/logo.png"));
        primaryStage.show();

    }
}
