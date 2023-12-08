
package com.example.demo3;

//Class Controls most of the program



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.Desktop;
import java.io.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo3.UserProfile; 

import java.util.regex.Pattern;

public class LoginController implements Initializable{

    @FXML
    private Label welcomeText;
    @FXML
    private Label welText;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button cancelButton;
    
    @FXML
    private TextField emailField;  // New email input field
    @FXML
    private PasswordField password_Field;
    @FXML
    private Button login_button;
    @FXML
    private Label messageLabel;
    
    private WorkoutLibrary workoutLibrary; // keep this field

    public void setWorkoutLibrary(WorkoutLibrary workoutLibrary) {
        this.workoutLibrary = workoutLibrary;
    }

    
    
    private ActivityLogController activityLogController;
    private WorkoutTrackerController workoutTrackerController;

    
    //for new users
    private String enteredUsername; 

    @FXML
    private void openUserProfile(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UsersProfile.fxml"));
            Parent root = loader.load();

            UsersProfileController usersProfileController = loader.getController();

            // Set the entered username in the UsersProfileController
            usersProfileController.setEnteredUsername(enteredUsername);

            // Initialize the WorkoutLibrary and pass it to the UsersProfileController
            WorkoutLibrary workoutLibrary = new WorkoutLibrary();
            usersProfileController.setWorkoutLibrary(workoutLibrary);

            // Call a method on usersProfileController that updates the UI with the exercises
            usersProfileController.updateExercisesInView(); // This method must be defined in UsersProfileController

            
           // usersProfileController.updateLast7Exercises(); // Add this line

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current stage (Login page)
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    
    
    @FXML
    private Button backToMainMenuButton;

    @FXML
    private void handleBackToMainMenu(ActionEvent event) {
        try {
            // Load the Main Menu FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            // Create a new scene with the loaded page
            Scene scene = new Scene(root);

            // Get the current stage (window) using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the current stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    private Button AppointmentsButton;
    
    @FXML
    private void handleAppointments(ActionEvent event) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Appointment.fxml"));
        	Parent root = loader.load();


            // Create a new scene with the loaded page
            Scene scene = new Scene(root);

            // Get the current stage (window) using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the current stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private Button Toji;
    
    @FXML
    private void Tojiopen(ActionEvent event) {
        try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Toji.fxml"));
        	Parent root = loader.load();


            // Create a new scene with the loaded page
            Scene scene = new Scene(root);

            // Get the current stage (window) using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the current stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private Button backToWorkoutPlansButton;

    @FXML
    private void handleBackToWorkoutPlansButton(ActionEvent event) {
        try {
            // Load the Main Menu FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            // Create a new scene with the loaded page
            Scene scene = new Scene(root);

            // Get the current stage (window) using the event source
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the scene on the current stage
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    

    @FXML
    private Button openNutritionalInfoButton;
    @FXML
    private void openNutritionalInfo(ActionEvent event) {
    	 try {
    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("NutritionalPage.fxml"));
    	        Parent root = loader.load();

    	        Stage stage = new Stage();
    	        
    	        stage.setScene(new Scene(root));

    	        stage.show();

    	        // Close the current stage (Login page)
    	        Stage currentStage = (Stage) openNutritionalInfoButton.getScene().getWindow();
    	        currentStage.close();
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }
    
    @FXML
    private Button openWebsiteButton;

    @FXML
    private void openWebsite(ActionEvent event) {
        String websiteURL = "https://guntj2.wixsite.com/farmingdale-fitness";
        
        try {
            // Create a URI object from the website URL
            URI uri = new URI(websiteURL);
            
            // Use the Desktop class to open the default web browser
            Desktop.getDesktop().browse(uri);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    public void initialize(URL location, ResourceBundle resources) {
    	 loadUserProfilesFromFile();  	
    }

    
    
    private List<UserProfile> userProfiles = new ArrayList<>(); // Store user profiles here

  
    @FXML
    protected void onSubmitButtonClick() {
        // Get user input from the form
        String enteredUsername = usernameField.getText();
        String enteredPassword = password_Field.getText();
        String enteredEmail = emailField.getText();

        // Create a UserProfile object with the entered data
        UserProfile userProfile = new UserProfile(enteredUsername, enteredEmail, enteredPassword);

        // Add the UserProfile object to the list
        userProfiles.add(userProfile);

        // Clear the input fields
        usernameField.clear();
        password_Field.clear();
        emailField.clear();

        // Save user profiles to a file
        saveUserProfilesToFile();

        // Display the user created confirmation message
        String confirmationMessage = enteredUsername + " has been created!";
        messageLabel.setText(confirmationMessage);
    }

    
    private void saveUserProfilesToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("userProfiles.dat"))) {
            out.writeObject(userProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 

    protected void loadUserProfilesFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("userProfiles.dat"))) {
            userProfiles = (List<UserProfile>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            
            e.printStackTrace();
        }
    }

    
   @FXML
    protected void onBackToLoginButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
           
            stage.setScene(new Scene(root));

            stage.show();

       
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    
    //Not needed
   /////////////////////////////////////////////////
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    //Not needed
    @FXML
    protected void OnClickMeButtonClick() {
        welText.setText("o JavaFX Application!");
    }

    @FXML
    protected void OnClickMecancelbuttonClick() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    ////////////////////////////////////////////////////////

    @FXML
    protected void onLoginButtonClick() {
    	
    	
    	    String enteredUsername = usernameField.getText();
    	    String enteredPassword = passwordField.getText();

    	    if (isValidLogin(enteredUsername, enteredPassword)) {
    	        openMenuPage();
    	    } else {
    	        displayError("Login Failed", "Invalid username or password.");
    	    }
    	}

    private boolean isValidLogin(String enteredUsername, String enteredPassword) {
        for (UserProfile userProfile : userProfiles) {
            if (userProfile.getUsername().equals(enteredUsername) && userProfile.getPassword().equals(enteredPassword)) {
                return true; // Matching profile found
            }
        }
        return false; // No matching profile found
    }
    

    
    private void openMenuPage() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Menu Page");
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage (Login page)
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    @FXML
    private Button newUserButton;

    @FXML
    private void onNewUserButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage (login page)
            Stage currentStage = (Stage) newUserButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    	
    	
    
    
    @FXML
    private Button WorkoutVideos;

    @FXML
    private void onWorkoutVideosButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutVideos.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Workout Videos");
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) WorkoutVideos.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button WorkoutPlans;

    @FXML
    private void onWorkoutPlansButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutPlans.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Workout Plans");
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) WorkoutPlans.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button RegularRoutine;

    @FXML
    private void onWorkoutPlansRegularRoutineButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegularRoutine.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
           
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) RegularRoutine.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button WednesdayandThursday;

    @FXML
    private void onWorkoutPlansRegularRoutineWednesdayButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Wednesday&Thursday.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
           
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) RegularRoutine.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private Button Friday;

    @FXML
    private void onWorkoutPlansRegularFridayButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Friday.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
           
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) RegularRoutine.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private Button Calisthenics;

    @FXML
    private void onWorkoutPlansCalisthenicsButtonClick(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Calisthenics.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
           
            stage.setScene(new Scene(root));

            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) RegularRoutine.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void handlePlanks(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Planks.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    

    @FXML
    private Button Push_Up;

    public void handleOpenPushupTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PushUpTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleChestPressTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChestPressTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void handleDumbBellFlyesTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DumbBellFlyesTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void handleSquatsTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SquatsTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleLegPressesTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LegPressesTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void handleLungesTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LungesTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void ShoulderPressesTutorial(MouseEvent mouseEvent) {
        try {
            // Load the PushUpTutorial.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoulderPressesTutorial.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) Push_Up.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}

