
package com.example.demo3;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class AppointmentController {

    @FXML
    private TextField dateField;

    @FXML
    private TextField timeField;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private Button scheduleButton;

    @FXML
    private Button viewAppointmentsButton;

    @FXML
    private Label appointmentInfoLabel;

    @FXML
    private ListView<String> appointmentListView;

    private ObservableList<String> appointmentList = FXCollections.observableArrayList();

    @FXML
    private void scheduleAppointment() {
        String date = dateField.getText();
        String time = timeField.getText();
        String description = descriptionArea.getText();

        // Create an appointment string
        String appointmentInfo = "Date: " + date + ", Time: " + time + ", Description: " + description;

        // Add the appointment to the list
        appointmentList.add(appointmentInfo);

        // Update the ListView to display the updated list of appointments
        appointmentListView.setItems(appointmentList);

        // Clear the appointment fields
        dateField.clear();
        timeField.clear();
        descriptionArea.clear();
    }

    
    
    
    @FXML
    private void viewAppointments() {
        System.out.println("View Appointments button clicked.");
    }
    
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

    
    
    
    
}


//Nafisas original code included appointments stored for user
//Was not implemented cuase there wasnt enough time


