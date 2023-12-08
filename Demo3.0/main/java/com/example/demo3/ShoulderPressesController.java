

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

public class ShoulderPressesController implements Initializable {
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
        // Replace the file path with the path to your video file
    	
        file = new File("C:\\Users\\alex3\\Downloads\\vecteezy_young-man-hand-holding-dumbbell-up-exercises-at-gym-fitness_1806315.mov");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        mediaPlayer.setOnReady(() -> {
            mediaPlayer.play();
        });
        
    }
}
    /*
    
    
    
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


*/




