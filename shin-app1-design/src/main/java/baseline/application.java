/*
 *  UCF COP3330 Summer 2021 Application Assignment 1 Solution
 *  Copyright 2021 Benjamin Shin
 */
package baseline;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class application extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("todolist.fxml")));

        Scene scene = new Scene(root);

        stage.setTitle("Mylist");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);

    }

}
