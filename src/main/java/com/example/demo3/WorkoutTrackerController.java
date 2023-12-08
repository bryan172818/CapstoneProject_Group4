
package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import java.util.List;

public class WorkoutTrackerController {

    @FXML
    private ListView<String> workoutListView;
    
    @FXML
    private AnchorPane mainPane;

    private List<String> loggedActivities;
    
    @FXML
    private ListView<Exercise> workoutListViews; // Updated ListView for Exercise objects

    private List<Exercise> loggedExercises; // Store logged exercises

   
    
    public void setLoggedExercises(List<Exercise> exercises) {
        loggedExercises = exercises;
        updateWorkoutListView(exercises); // Update the exercise list view
    }


    public void initialize() {
        System.out.println("Debug: Initializing WorkoutTrackerController");

        // Clear the previous items and add new ones
//        workoutListView.getItems().clear();
//        if (loggedActivities != null) {
//            workoutListView.getItems().addAll(loggedActivities);
//        }
//
//        int totalExercises = calculateTotalExercises(); // Use calculateTotalExercises method
//        System.out.println("Debug: Total Exercises calculated: " + totalExercises);
//
//        Label totalExercisesLabel = new Label("Total Exercises: " + totalExercises);
//        mainPane.getChildren().add(totalExercisesLabel);
//        AnchorPane.setTopAnchor(totalExercisesLabel, 10.0);
//        AnchorPane.setLeftAnchor(totalExercisesLabel, 10.0);
    }


    public void updateExerciseCountAndDisplay() {
        int totalExercises = (loggedExercises != null) ? loggedExercises.size() : 0;
        System.out.println("Debug: Total Exercises updated: " + totalExercises);

        Label totalExercisesLabel = new Label("Total Exercises: " + totalExercises);
        mainPane.getChildren().add(totalExercisesLabel);
        AnchorPane.setBottomAnchor(totalExercisesLabel, 10.0);
        AnchorPane.setLeftAnchor(totalExercisesLabel, 10.0);
    }

    
    

    
    private int calculateTotalExercises() {
        // Check if loggedExercises is null
        if (loggedExercises == null) {
            System.out.println("Debug: loggedExercises is null");
            return 0;
        }

        // Print the size of the loggedExercises list
        System.out.println("Debug: Number of logged exercises: " + loggedExercises.size());

        // Return the number of logged exercises
        return loggedExercises.size();
    }
    
    private boolean containsExerciseDetails(String logEntry) {
       
        return logEntry.contains("Exercise:") && logEntry.contains("Duration:") && logEntry.contains("Distance:");
    }

    @FXML
    public void goBack() {
        mainPane.getScene().getWindow().hide();
    }
   
    
    public void updateWorkoutListView(List<Exercise> exercises) {
        System.out.println("Debug: Updating workoutListViews with exercises:");
        
        workoutListViews.getItems().clear();
        workoutListViews.getItems().addAll(exercises);
        
        System.out.println("Debug: Number of exercises in workoutListViews: " + workoutListViews.getItems().size());
        
        for (Exercise exercise : exercises) {
            System.out.println("Debug: Exercise added: " + exercise.toString());
        }
    }

}
