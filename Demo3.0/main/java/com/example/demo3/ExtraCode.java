/**
 * 
 */
package com.example.demo3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 */
public class ExtraCode {

//
//    @FXML
//    protected void onLoginButtonClick() {
//        String enteredUsername = usernameField.getText();
//        String enteredPassword = passwordField.getText();
//
//        if (enteredUsername.equals("Jeff") && enteredPassword.equals("Jeff1")) {
//
//
//            try {
//                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
//                Parent root = loader.load();
//                Stage menuStage = new Stage();
//                menuStage.setScene(new Scene(root));
//                menuStage.show();
//
//
//                Stage loginStage = (Stage) usernameField.getScene().getWindow();
//                loginStage.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            //welcomeText.setText("Invalid username or password");
//        }
//    }
//    
    
    


// ... other methods ...
//@FXML
//protected void onSubmitButtonClick(ActionEvent event) {
//    // Get user input from the form
//    String enteredUsername = usernameField.getText();
//    String enteredPassword = password_Field.getText();
//    String enteredEmail = emailField.getText();  // Get email input
//
//    // Create a UserProfile object with the entered data
//    UserProfile userProfile = new UserProfile(enteredUsername, enteredEmail, enteredPassword);
//
//    // Add the UserProfile object to the list
//    userProfiles.add(userProfile);
//
//    // Display user information
//    System.out.println("User Credentials Stored:");
//    System.out.println("Username: " + userProfile.getUsername());
//    System.out.println("Email: " + userProfile.getEmail());
//    System.out.println("Password: " + userProfile.getPassword());
//
//    // Clear the input fields
//    usernameField.clear();
//    password_Field.clear();
//    emailField.clear();
//
//    // Optionally, you can save the userProfiles list to a file for persistent storage.
//}












// Rest of your code...

//@FXML first attepmt Dont delete yet!!!!!!!!!!!!!!!!!!!!!!!!!!!
//protected void onSubmitButtonClick(ActionEvent event) {
//    // Get user input from the form
//    String enteredUsername = usernameField.getText();
//    String enteredPassword = password_Field.getText();
//    // You can also get the emailField value if needed.
//
//    // Create a UserProfile object with the entered data
//    UserProfile userProfile = new UserProfile(enteredUsername, enteredPassword, ""); // Replace "" with the email if needed.
//
//    // Add the UserProfile object to the list
//    userProfiles.add(userProfile);
////
////    // Display a message to inform the user that the information has been stored
////    Alert alert = new Alert(Alert.AlertType.INFORMATION);
////    alert.setTitle("Information Stored");
////    alert.setHeaderText(null);
////    alert.setContentText("Your information has been stored.");
////    alert.showAndWait();
//    System.out.println("User Credentials Stored:");
//    System.out.println("Username: " + userProfile.getUsername());
//    System.out.println("Password: " + userProfile.getPassword());
//    
//    // Clear the input fields
//    usernameField.clear();
//    password_Field.clear();
//    // Clear emailField if needed.
//
//    // Optionally, you can save the userProfiles list to a file for persistent storage.
//
//   //// event.consume(); // Prevent further handling of the event
//}
//
@FXML
protected void onBackToLoginButtonClick(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        // Set the title for the login page
       // stage.setTitle("Login Page");
        stage.setScene(new Scene(root));

        stage.show();

        // Close the current stage (New Users page)
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}





//
//New Code for if the login is successful implement this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	@FXML
//	protected void onLoginUserButtonClick(ActionEvent event) {
//	    // Get user input from the form
//	    String enteredUsername = usernameField.getText();
//	    String enteredPassword = password_Field.getText();
//
//	    // Check if the entered username and password match any existing user profiles
//	    for (UserProfile userProfile : userProfiles) {
//	        if (userProfile.getUsername().equals(enteredUsername) && userProfile.getPassword().equals(enteredPassword)) {
//	            // Successful login
//	            openMenuPage();
//	            return;
//	        }
//	    }
//
//	    // If the loop finishes without finding a matching user, display an error message.
//	    displayError("Login Failed", "Invalid username or password.");
//	}
//
//	private void openMenuPage() {
//	    try {
//	        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
//	        Parent root = loader.load();
//
//	        Stage stage = new Stage();
//	        stage.setTitle("Menu Page");
//	        stage.setScene(new Scene(root));
//
//	        stage.show();
//
//	        // Close the current stage (Login page)
//	        Stage currentStage = (Stage) usernameField.getScene().getWindow();
//	        currentStage.close();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
//???????????????????????????????????????????????????????????????????????????????????????????????????
//	
	
	
//
//private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
//
//
//private List<UserProfile> userProfiles = new ArrayList<>(); // Store user profiles
//
//
//@FXML
//protected void onSubmitButtonClick() {
//  // Get user input from the form
//  String enteredUsername = usernameField.getText();
//  String enteredPassword = password_Field.getText();
//  String enteredEmail = emailField.getText(); // Get email input
//
//  // Check if the entered email is acceptable using regex pattern
//  if (!isValidEmail(enteredEmail)) {
//      displayError("Invalid Email", "Please enter a valid email address.");
//      return;
//  }
//
//  // Create a UserProfile object with the entered data
//  UserProfile userProfile = new UserProfile(enteredUsername, enteredEmail, enteredPassword);
//
//  // Add the UserProfile object to the list
//  userProfiles.add(userProfile);
//
//  // Display user information
//  System.out.println("User Credentials Stored:");
//  System.out.println("Username: " + userProfile.getUsername());
//  System.out.println("Email: " + userProfile.getEmail());
//  System.out.println("Password: " + userProfile.getPassword());
//  
//// Display a confirmation message
//  String confirmationMessage = enteredUsername + " has been created!";
//  messageLabel.setText(confirmationMessage);
//
//
//  // Clear the input fields
//  usernameField.clear();
//  password_Field.clear();
//  emailField.clear();
//
//  // Optionally, you can save the userProfiles list to a file for persistent storage.
//}
//
//// ...
//
//// Helper method to validate email using regex
//private boolean isValidEmail(String email) {
//  // Define a common email pattern using a well-known regex
//  String commonEmailPattern = ".+";
//  Pattern pattern = Pattern.compile(commonEmailPattern);
//  return pattern.matcher(email).matches();
//}
//
//// Helper method to display an error dialog
//private void displayError(String title, String message) {
//  Alert alert = new Alert(Alert.AlertType.ERROR);
//  alert.setTitle(title);
//  alert.setHeaderText(null);
//  alert.setContentText(message);
//  alert.showAndWait();
//}
//
//// ...
//












//
//// ... other methods ...
//@FXML
//protected void onSubmitButtonClick(ActionEvent event) {
//  // Get user input from the form
//  String enteredUsername = usernameField.getText();
//  String enteredPassword = password_Field.getText();
// String enteredEmail = emailField.getText();  // Get email input
//
// // Create a UserProfile object with the entered data
//  UserProfile userProfile = new UserProfile(enteredUsername, enteredEmail, enteredPassword);        
//  // Add the UserProfile object to the list
//  userProfiles.add(userProfile);
//
// // Display user information
// System.out.println("User Credentials Stored:");
// System.out.println("Username: " + userProfile.getUsername());
// System.out.println("Email: " + userProfile.getEmail());
//  System.out.println("Password: " + userProfile.getPassword());
//
//  // Clear the input fields
// usernameField.clear();
// password_Field.clear();
//  emailField.clear();
//
//  // Optionally, you can save the userProfiles list to a file for persistent storage.
//}


// Rest of your code...

//@FXML first attepmt Dont delete yet!!!!!!!!!!!!!!!!!!!!!!!!!!!
//protected void onSubmitButtonClick(ActionEvent event) {
//  // Get user input from the form
//  String enteredUsername = usernameField.getText();
//  String enteredPassword = password_Field.getText();
//  // You can also get the emailField value if needed.
//
//  // Create a UserProfile object with the entered data
//  UserProfile userProfile = new UserProfile(enteredUsername, enteredPassword, ""); // Replace "" with the email if needed.
//
//  // Add the UserProfile object to the list
//  userProfiles.add(userProfile);
////
////  // Display a message to inform the user that the information has been stored
////  Alert alert = new Alert(Alert.AlertType.INFORMATION);
////  alert.setTitle("Information Stored");
////  alert.setHeaderText(null);
////  alert.setContentText("Your information has been stored.");
////  alert.showAndWait();
//  System.out.println("User Credentials Stored:");
//  System.out.println("Username: " + userProfile.getUsername());
//  System.out.println("Password: " + userProfile.getPassword());
//  
//  // Clear the input fields
//  usernameField.clear();
//  password_Field.clear();
//  // Clear emailField if needed.
//
//  // Optionally, you can save the userProfiles list to a file for persistent storage.
//
// //// event.consume(); // Prevent further handling of the event
//}
//





























//
//
//package com.example.demo3;
//
//import javafx.fxml.FXML;
//
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextArea;
//import javafx.fxml.FXML;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Slider;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javafx.scene.control.Label;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WorkoutController {
//	
//	
//	
//    @FXML
//    private ListView<String> exerciseListView;
//
//    @FXML
//    private TextArea workoutDetailsTextArea;
//    
//    private final List<Activity> activities = new ArrayList<>();
//
//    @FXML
//    private Button startWorkoutButton;
//
//    // Set up the WorkoutLibrary and UserProfileController
//    private WorkoutLibrary workoutLibrary;
//    private UsersProfileController userProfileController;
//    public void someMethod() {
//        // Here, use the instance to call getCurrentUser()
//        UserProfile currentUser = userProfileController.getCurrentUser();
//        // rest of your code...
//    }
//    public void setUserProfileController(UsersProfileController usersProfileController) {
//        this.userProfileController = usersProfileController;
//    }
//
//    public void setWorkoutLibrary(WorkoutLibrary workoutLibrary) {
//        this.workoutLibrary = workoutLibrary;
//    }
//    @FXML
//    public void initialize() {
//    	  if (workoutLibrary != null) {
//              List<Exercise> allExercises = workoutLibrary.getAllExercises();
//              List<String> exerciseNames = allExercises.stream()
//                                                      .map(Exercise::getName)
//                                                      .collect(Collectors.toList());
//              ObservableList<String> observableExerciseList = FXCollections.observableArrayList(exerciseNames);
//              exerciseListView.setItems(observableExerciseList);
//          }
//        // Initialize the exerciseListView with exercises from the WorkoutLibrary
//       //Nafisas Code exerciseListView.getItems().addAll(workoutLibrary.getExercise());
//    }
//
//    @FXML
//    public void startWorkout() {
//        // Get selected exercises from the list
//        List<String> selectedExercises = exerciseListView.getSelectionModel().getSelectedItems();
//
//        // Create a new workout session
//        //WorkoutSession workoutSession = new WorkoutSession(UsersProfileController.getCurrentUser(), selectedExercises);
//
//        // Update the workout details text area
//       // workoutDetailsTextArea.setText(workoutSession.toString());
//
//
//    }
//    
//    
//
//    @FXML
//    private ComboBox<String> activityTypeComboBox; // Assuming ComboBox for activity type
//
//    @FXML
//    private TextField durationTextField; // TextField for duration
//
//    @FXML
//    private TextField distanceTextField; // TextField for distance
//
//    @FXML
//    private Slider intensitySlider; // Slider for intensity
//
//    
//    //create variables for this
//    @FXML
//    private void onAddActivity() {
//        String type = activityTypeComboBox.getValue();
//        double duration = Double.parseDouble(durationTextField.getText());
//        double distance = Double.parseDouble(distanceTextField.getText());
//        int intensity = (int) intensitySlider.getValue();
//
//        Activity newActivity = new Activity(type, duration, distance, intensity);
//        activities.add(newActivity);
//        updateActivityListView();
//    }
//    @FXML
//    private ListView<String> activityListView;
//
//    private void updateActivityListView() {
//        List<String> activityDescriptions = activities.stream()
//                .map(activity -> activity.getType() + " - Duration: " + activity.getDuration() + " mins")
//                .collect(Collectors.toList());
//        ObservableList<String> observableList = FXCollections.observableArrayList(activityDescriptions);
//        activityListView.setItems(observableList);
//    }
//
//
//    public UsersProfileController getUserProfileController() {
//        return userProfileController;
//    }
//}
//
//












//public void initializeExerciseListView() {
//  if (workoutLibrary != null) {
//      ObservableList<Exercise> observableExerciseList = FXCollections.observableArrayList(workoutLibrary.getAllExercises());
//      exerciseListView.setItems(observableExerciseList);
//
//      exerciseListView.setCellFactory(param -> new ListCell<Exercise>() {
//          @Override
//          protected void updateItem(Exercise exercise, boolean empty) {
//              super.updateItem(exercise, empty);
//              if (empty || exercise == null) {
//                  setText(null);
//              } else {
//                  setText(exercise.getName());
//              }
//          }
//      });
//
//      exerciseListView.getSelectionModel().selectedItemProperty().addListener(
//          (observable, oldValue, newValue) -> {
//              if (newValue != null) {
//                  workoutDetailsTextArea.setText(newValue.getDescription());
//              }
//          }
//      );
//  }
//}


//////////////////Nafisas Original LogActivity FXML FILE and Controller
//<?xml version="1.0" encoding="UTF-8"?>
//
//<?import javafx.scene.control.Button?>
//<?import javafx.scene.control.Label?>
//<?import javafx.scene.control.ListView?>
//<?import javafx.scene.layout.VBox?>
//<!-- activity_log.fxml -->
//
//<VBox xmlns="http://javafx.com/javafx"
//      xmlns:fx="http://javafx.com/fxml"
//      fx:controller="com.example.demo3.ActivityLogController">
//
//
//    <!-- Label for the list of logged activities -->
//    <Label text="Activity Log"/>
//
//    <!-- ListView to display logged activities -->
//    <ListView fx:id="activityLogListView" prefHeight="300"/>
//
//    <!-- Button to go back to the main menu or another page -->
//    <Button text="Back" onAction="#goBack"/>
//
//</VBox>
//






//package com.example.demo3;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//
//public class ActivityLogController {
//
//    @FXML
//    private ListView<String> activityLogListView;
//    
//
//
//    private UsersProfileController userProfileController;
//
//    @FXML
//    public void initialize() {
//        // Load and display the logged activities
//       // loadActivityLog();
//    }
//
////    private void loadActivityLog() {
////
////        List<String> loggedActivities = userProfileController.getLoggedActivities();
////
////        // Display logged activities in the ListView
////        // Have to update the UserProfileController and LoginController
////        activityLogListView.getItems().addAll(loggedActivities);
////    }
//
//    @FXML
//    public void goBack() {
//        // to keep it simple activity log has been closed here
//        activityLogListView.getScene().getWindow().hide();
//    }
//}





/////////////////////Original Mian menu
//
//package com.example.demo3;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import java.io.IOException;
//
//public class LoginApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        // Initialize the WorkoutLibrary
//        WorkoutLibrary workoutLibrary = new WorkoutLibrary(); // You can add exercises in the constructor
//
//        
//        // Create an instance of LoginController and set the workout library
//        LoginController loginController = new LoginController();
//        loginController.setWorkoutLibrary(workoutLibrary);
//
//        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("Login.fxml"));
//
//        // Set the controller for the FXML file
//        fxmlLoader.setController(loginController);
//
//        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
//        stage.setTitle("Login");
//        stage.setScene(scene);
//        stage.show();
//
//        // Call the loadUserProfilesFromFile method on the instance
//        loginController.loadUserProfilesFromFile();
//        
//        
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

//////////////////////////////////////Next Steps
//Thank you for providing your WorkoutTrackerController class and FXML file. I can see the issue now.
//
//The problem is that you have two ListView elements in your WorkoutTracker.fxml file: one with the fx:id "workoutListView" and another with the fx:id "workoutListViews." However, in your WorkoutTrackerController class, you've declared only one ListView field with the variable name workoutListViews. This causes a mismatch between the fx:id in your FXML file and the variable name in your controller.
//
//To fix this issue, you should ensure that the fx:id in your FXML file matches the variable name in your controller. Based on your controller code, you should update your FXML file as follows:
//
//xml
//Copy code
//<ListView fx:id="workoutListViews" prefHeight="300" />
//Make sure that you have saved your FXML file after making this change.
//
//Once you've made this correction, your code should work as expected. The ListView with the fx:id "workoutListViews" will be correctly injected into the workoutListViews field in your controller, and you'll be able to update it with exercises when you call the setLoggedExercises method.
//
//After making this change, try running your application again, and it should resolve the "Cannot invoke 'javafx.scene.control.ListView.getItems()' because 'this.workoutListViews' is null" error.
//
//














}


