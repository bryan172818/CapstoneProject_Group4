
package com.example.demo3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



//Modify this class so the initialization can work
public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Initialize the WorkoutLibrary
        WorkoutLibrary workoutLibrary = new WorkoutLibrary(); // You can add exercises to the constructor

        
        
        LoginController loginController = new LoginController();
        loginController.setWorkoutLibrary(workoutLibrary);

        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("Login.fxml"));

        // Set the controller for the FXML file
        fxmlLoader.setController(loginController);

        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();

        // Call the loadUserProfilesFromFile method on the instance
        loginController.loadUserProfilesFromFile();
        
        
    }

    public static void main(String[] args) {
        launch();
    }
}

