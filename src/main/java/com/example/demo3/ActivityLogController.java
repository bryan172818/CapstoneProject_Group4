package com.example.demo3;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class ActivityLogController {

    @FXML
    private ListView<String> activityLogListView;

    @FXML
    private TextField exerciseNameTextField;

    @FXML
    private TextField durationTextField;

    @FXML
    private TextField distanceTextField;

    private UsersProfileController userProfileController;

    private List<String> loggedActivities = new ArrayList<>();
    private List<Exercise> loggedExercises = new ArrayList<>(); // Store logged exercises

    public List<Exercise> getLoggedExercises() {
        return loggedExercises;
    }
    
    
    
    @FXML
    public void initialize() {
        // Load and display the logged activities
        loadActivityLog();
    }

    private void loadActivityLog() {
        // Display logged activities in the ListView
        activityLogListView.getItems().addAll(loggedActivities);
    }

    @FXML
    public void goBack() {
        // Close the activity log window
        activityLogListView.getScene().getWindow().hide();
    }
    
    

    @FXML
    public void logExercise() {
        // Retrieve exercise details from input fields
        String exerciseName = exerciseNameTextField.getText();
        String duration = durationTextField.getText();
        String distance = distanceTextField.getText();

        // Create a new Exercise instance with the entered details
        Exercise loggedExercise = new Exercise(exerciseName, "Duration: " + duration + " mins, Distance: " + distance + " miles");

        // Add the logged exercise to the list
        loggedExercises.add(loggedExercise);

        // Clear input fields
        exerciseNameTextField.clear();
        durationTextField.clear();
        distanceTextField.clear();

        // Update the ListView with the new logged exercise
        activityLogListView.getItems().add(loggedExercise.toString());
    }

    @FXML 
    private Button TrackWorkout;

   


    @FXML
    public void viewWorkouts() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutTracker.fxml"));
            Parent root = loader.load();

            WorkoutTrackerController workoutTrackerController = loader.getController();
            workoutTrackerController.setLoggedExercises(loggedExercises);
            workoutTrackerController.updateExerciseCountAndDisplay(); // Update the count and display them

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    

}

