


package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Slider;
import javafx.scene.control.ListCell;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class WorkoutController {
    @FXML
    private ListView<Exercise> exerciseListView;

    @FXML
    private TextArea workoutDetailsTextArea;

    @FXML
    private Button startWorkoutButton;

    @FXML
    private ComboBox<String> activityTypeComboBox;

    @FXML
    private TextField durationTextField;

    @FXML
    private TextField distanceTextField;

    @FXML
    private Slider intensitySlider;
    
    @FXML
    private VBox last7ExercisesVBox; 

    @FXML
    private ListView<String> activityListView;

    private final List<Activity> activities = new ArrayList<>();
    private WorkoutLibrary workoutLibrary;
    private UsersProfileController userProfileController;

    @FXML
    public void initialize() {
        if (workoutLibrary != null) {
            ObservableList<Exercise> observableExerciseList = FXCollections.observableArrayList(workoutLibrary.getAllExercises());
            exerciseListView.setItems(observableExerciseList);

            exerciseListView.setCellFactory(param -> new ListCell<Exercise>() {
                @Override
                protected void updateItem(Exercise exercise, boolean empty) {
                    super.updateItem(exercise, empty);
                    if (empty || exercise == null) {
                        setText(null);
                    } else {
                        setText(exercise.getName());
                    }
                }
            });

            exerciseListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        workoutDetailsTextArea.setText(newValue.getDescription());
                    }
                }
            );
        }

        updateActivityListView();
    }
    
    
 // Make this method public
    public void initializeExerciseListView() {
        if (workoutLibrary != null) {
            ObservableList<Exercise> observableExerciseList = FXCollections.observableArrayList(workoutLibrary.getAllExercises());
            exerciseListView.setItems(observableExerciseList);

            exerciseListView.setCellFactory(param -> new ListCell<Exercise>() {
                @Override
                protected void updateItem(Exercise exercise, boolean empty) {
                    super.updateItem(exercise, empty);
                    if (empty || exercise == null) {
                        setText(null);
                    } else {
                        setText(exercise.getName());
                    }
                }
            });

            exerciseListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        workoutDetailsTextArea.setText(newValue.getDescription());
                    }
                }
            );
        }
    }
    
    
    public void setWorkoutLibrary(WorkoutLibrary workoutLibrary) {
        this.workoutLibrary = workoutLibrary;
        initializeExerciseListView();
    }
   


    @FXML
    private void onAddActivity() {
        String type = activityTypeComboBox.getValue();
        double duration = Double.parseDouble(durationTextField.getText());
        double distance = Double.parseDouble(distanceTextField.getText());
        int intensity = (int) intensitySlider.getValue();

        Activity newActivity = new Activity(type, duration, distance, intensity);
        activities.add(newActivity);
        updateActivityListView();
    }

    private void updateActivityListView() {
        List<String> activityDescriptions = activities.stream()
                .map(activity -> activity.getType() + " - Duration: " + activity.getDuration() + " mins")
                .collect(Collectors.toList());
        ObservableList<String> observableList = FXCollections.observableArrayList(activityDescriptions);
        activityListView.setItems(observableList);
    }

    @FXML
    public void startWorkout() {
        List<Exercise> selectedExercises = exerciseListView.getSelectionModel().getSelectedItems();
        
    }

    public void setUserProfileController(UsersProfileController usersProfileController) {
        this.userProfileController = usersProfileController;
    }

    

    public UsersProfileController getUserProfileController() {
        return userProfileController;
    }
    
    @FXML
    private void OpenWorkout() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ActivityLog.fxml"));
            Parent root = loader.load();

            // Create a new stage (window) for the ActivityLog.fxml
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            
        } catch (IOException e) {
            e.printStackTrace();
 
        }
    }
    private WorkoutController workoutController;

 

    public void setWorkoutController(WorkoutController workoutController) {
        this.workoutController = workoutController;
    }
 
 // Call this method to update the last 7 exercises
    public void updateLast7Exercises() {
        if (workoutController != null && workoutLibrary != null) {
            System.out.println("Updating last 7 exercises...");
            List<Exercise> allExercises = workoutLibrary.getAllExercises();
            last7ExercisesVBox.getChildren().clear(); 
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

    
   
}

