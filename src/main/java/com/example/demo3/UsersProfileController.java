package com.example.demo3;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.io.*;
import java.util.List;
import javafx.scene.layout.VBox;


public class UsersProfileController implements Initializable {

	@FXML
    private Label welcomeLabel;

    @FXML
    private Label usernameLabel;

    private String enteredUsername;

    @FXML
    private VBox exerciseVBox; // Use VBox for exercise display

    private WorkoutLibrary workoutLibrary;

    public void setWorkoutLibrary(WorkoutLibrary workoutLibrary) {
        this.workoutLibrary = workoutLibrary;
    }

    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    
    @FXML
    private VBox last7ExercisesVBox; // Reference to the new VBox for exercises

    // Function no longer needed
    public void updateLast7Exercises() {
        if (workoutLibrary != null) {
            List<Exercise> allExercises = workoutLibrary.getAllExercises();
            last7ExercisesVBox.getChildren().clear(); // Clear previous content

            // Calculate the index to start from to get the last 7 exercises
            int startIndex = Math.max(0, allExercises.size() - 7);

            for (int i = startIndex; i < allExercises.size(); i++) {
                Exercise exercise = allExercises.get(i);
                Label exerciseLabel = new Label(exercise.getName());
             
                last7ExercisesVBox.getChildren().add(exerciseLabel);
                System.out.println("Added exercise to last 7: " + exercise.getName()); // Debug statement
            }

            System.out.println("Last 7 exercises updated successfully."); // Debug statement
        }
    }

   
 // Call this method to update the last 7 exercises
    
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing UsersProfileController");

        // Load user profiles from the file
        List<UserProfile> userProfiles = loadUserProfilesFromFile();

        // Display the entered username
        if (enteredUsername != null) {
            welcomeLabel.setText("Welcome " + enteredUsername);
            usernameLabel.setText("Username: " + enteredUsername);
        }

        if (workoutLibrary != null) {
            exerciseVBox.getChildren().clear(); // Clear previous content
            last7ExercisesVBox.getChildren().clear(); // Clear previous content in the second VBox

            // Debugging output: print the list of all exercises
            System.out.println("All exercises loaded:");
            List<Exercise> allExercises = workoutLibrary.getAllExercises();
            
            // Add the first 7 exercises to the exerciseVBox
            int endIndexExerciseVBox = Math.min(7, allExercises.size());
            for (int i = 0; i < endIndexExerciseVBox; i++) {
                Exercise exercise = allExercises.get(i);
                Label exerciseLabel = new Label(exercise.getName());
               
                exerciseVBox.getChildren().add(exerciseLabel);
                System.out.println("Added exercise to exerciseVBox: " + exercise.getName());
            }

            // Add the remaining exercises to the last7ExercisesVBox
            for (int i = 7; i < allExercises.size(); i++) {
                Exercise exercise = allExercises.get(i);
                Label exerciseLabel = new Label(exercise.getName());
               
                last7ExercisesVBox.getChildren().add(exerciseLabel);
                System.out.println("Added exercise to last7ExercisesVBox: " + exercise.getName());
            }
        } else {
            System.out.println("WorkoutLibrary is null");
        }
    }



    // Load user profiles from the userProfiles.dat file
    private List<UserProfile> loadUserProfilesFromFile() {
        List<UserProfile> userProfiles = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userProfiles.dat"))) {
            userProfiles = (List<UserProfile>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userProfiles;
    }
   
 // Inside UsersProfileController
    public void updateExercisesInView() {
        if (exerciseVBox != null && workoutLibrary != null) {
            exerciseVBox.getChildren().clear();
            for (Exercise exercise : workoutLibrary.getAllExercises()) {
                Label exerciseLabel = new Label(exercise.getName());
                exerciseVBox.getChildren().add(exerciseLabel);
            }
        } else {
            System.out.println("exerciseVBox or workoutLibrary is null");
        }
    }
    
    // List to store activities
    private List<Activity> loggedActivities = new ArrayList<>();

    

    // Method to add an activity to the list
    public void logActivity(Activity activity) {
        loggedActivities.add(activity);
    }

    // Method to get logged activities as a list of strings
    public List<String> getLoggedActivities() {
        return loggedActivities.stream()
                .map(activity -> activity.getType() + " - Duration: " + activity.getDuration() + " mins")
                .collect(Collectors.toList());
    }
    


    private UserProfile currentUser;

    public UserProfile getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserProfile currentUser) {
        this.currentUser = currentUser;
    }

    @FXML
    private Button openWorkoutPageButton;
    
    
    @FXML
    private void openWorkoutPage() {
        try {
            System.out.println("Button clicked, opening workout page...");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutPage.fxml"));
            Parent root = loader.load();

            // Get the WorkoutController and set the WorkoutLibrary
            WorkoutController workoutController = loader.getController();
            workoutController.setWorkoutLibrary(workoutLibrary);

            // Load exercises from the library
            workoutController.initializeExerciseListView();
            System.out.println("Loaded exercises from the library in WorkoutController.");

            // Create a new stage (window) or use an existing stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

           
            ((Stage) openWorkoutPageButton.getScene().getWindow()).close();
            System.out.println("Closed the current window.");
        } catch (IOException e) {
            e.printStackTrace();
         
            System.err.println("Error opening Workout page: " + e.getMessage());
        }
    }
    
    private WorkoutController workoutController;

    

    public void setWorkoutController(WorkoutController workoutController) {
        this.workoutController = workoutController;
    }
 
    
}
	
	
	