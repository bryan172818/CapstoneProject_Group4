
	
	package com.example.demo3;


	import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;
	import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

	import java.io.File;
import java.io.IOException;
import java.net.URL;
	import java.util.ResourceBundle;
	
	//Video Controllers are all the same

	public class ChestPressController implements Initializable {
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
	        // Replace the file path with the path to the video file for each new controller
	    	
	        file = new File("C:\\Users\\alex3\\Downloads\\pexels-kampus-production-6892972 (2160p).mp4");
	        media = new Media(file.toURI().toString());
	        mediaPlayer = new MediaPlayer(media);
	        mediaView.setMediaPlayer(mediaPlayer);

	        mediaPlayer.setOnReady(() -> {
	            mediaPlayer.play();
	        });
	        
	    }
	    
	    
	    //Button text is changed when it is clicked
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
	        
	}}
	    
	    //Code is the same for all the video controllers
	    
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
	






