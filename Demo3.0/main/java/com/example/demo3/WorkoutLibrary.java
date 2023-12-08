

package com.example.demo3;
import java.util.ArrayList;
import java.util.List;

public class WorkoutLibrary {
    private List<Exercise> exercises;
    
    
    public WorkoutLibrary() {
        exercises = new ArrayList<>();
        initializeLibrary();
        System.out.println("WorkoutLibrary initialized with " + exercises.size() + " exercises.");
    }

    public void initializeLibrary() {
        // Add exercises to the library
        exercises.add(new Exercise("Push-Up", "A bodyweight exercise that targets the chest, shoulders, and triceps."));
        exercises.add(new Exercise("Squats", "A lower body exercise that targets the quadriceps, hamstrings, and glutes."));
    }



    public List<Exercise> getAllExercises() {
        return exercises;
    }

    public Exercise getExerciseByName(String name) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equalsIgnoreCase(name)) {
                return exercise;
            }
        }
        return null;
    }
}
