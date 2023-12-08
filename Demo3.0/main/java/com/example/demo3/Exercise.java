
package com.example.demo3;


import java.util.ArrayList;
import java.util.List;

class Exercise {
    private String name;
    private String description;

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Exercise: " + name + "\nDescription: " + description;
    }
}





















/*


Not needed yet


package com.example.demo3;

public class Exercise {
    private String exerciseName;
    private String description;
    private String videoUrl;

    public Exercise(String exerciseName, String description, String videoUrl) {
        this.exerciseName = exerciseName;
        this.description = description;
        this.videoUrl = videoUrl;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }









}
*/