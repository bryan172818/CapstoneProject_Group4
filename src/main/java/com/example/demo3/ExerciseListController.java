
package com.example.demo3;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class ExerciseListController implements Initializable {
    @FXML
    private MediaView mediaView;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


@FXML
private Button PauseButton;
@FXML
private Button ResetButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       
    	
        file = new File("C:\\Users\\alex3\\Downloads\\production_id_4754030 (2160p).mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
        });
        
    }
    
    public void playChestPressVideo(URL url, ResourceBundle resourceBundle) {
       
    	
        file = new File("C:\\Users\\alex3\\Downloads\\pexels-kampus-production-6892972 (2160p).mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
        });
        
    }
    
    
    
    public void pauseMedia() {
    	if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
            PauseButton.setText("Play Video");
        } else {
            mediaPlayer.play();
            PauseButton.setText("Pause Video");
        
    }
    }
   

    
    
    public void resetMedia() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY) {
            mediaPlayer.seek(Duration.seconds(0.0));
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED) {
                mediaPlayer.play();
            }
        
}
    }
    @FXML
    private Button goBackButton;

    
    @FXML
    private void handleGoBack(ActionEvent event) {
        try {
            // Load the WorkoutVideos FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkoutVideos.fxml")); 
            Parent root = loader.load();

            // Get the current window and set the new scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
}































/*
package com.example.demo3;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class ExerciseListController implements Initializable {
@FXML
private MediaView mediaView;

@FXML
private Button PlayButton, PauseButton, ResetButton;

private File file;
private Media media;
private MediaPlayer mediaPlayer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    file = new File("production_id_4754030 (2160p).mp4");
    media = new Media(file.toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaView.setMediaPlayer(mediaPlayer);
    }


    public void playMedia() {
    mediaPlayer.play();
    }

    public void pauseMedia(){
    mediaPlayer.pause();
    }

    public void resetMedia() {
        if(mediaPlayer.getStatus() != MediaPlayer.Status.READY){
        mediaPlayer.seek(Duration.seconds(0.0));
    }


    }}
        
        
        
        */


/*
package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class ExerciseListController {
    @FXML
    private MediaView mediaView;

    private MediaPlayer mediaPlayer;

    // Initialize the media player and media view
    @FXML
    public void initialize() {
        // Replace the file path with the actual path to your video file.
        String videoFilePath = "C:\\Users\\alex3\\Downloads\\production_id_4754030 (2160p).mp4";

        Media media = new Media(new File(videoFilePath).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
    }

    // Handle the "Push Up" button click
    @FXML
    private void handlePushUpButton(ActionEvent event) {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
        }
    }
}



*/


























 