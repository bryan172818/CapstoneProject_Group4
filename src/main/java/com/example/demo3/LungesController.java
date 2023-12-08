
package com.example.demo3;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;



public class LungesController implements Initializable {
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
      
    	
        file = new File("C:\\Users\\alex3\\Downloads\\production_id_5025833 (1080p).mp4");
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
        
}}


}
