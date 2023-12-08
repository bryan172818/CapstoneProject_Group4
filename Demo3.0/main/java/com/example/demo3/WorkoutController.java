


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
    
    
 // Make the method public
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
        // Here you can handle the selected exercises
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

            // Optional: If you want to close the current window
            // ((Stage) startWorkoutButton.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception, maybe show an alert to the user
        }
    }

    // Additional methods (if any)...
}

