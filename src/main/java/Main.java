package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        Parent root = FXMLLoader.load(Thread.currentThread().getContextClassLoader().getResource("main/resources/fxml/login.fxml"));
        // show UI
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("登录");

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
