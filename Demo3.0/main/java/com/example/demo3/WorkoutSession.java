package com.example.demo3;

import java.util.List;

public class WorkoutSession {

    private final UserProfile user;
    private final List<String> selectedExercises;


    public WorkoutSession(UserProfile user, List<String> selectedExercises) {
        this.user = user;
        this.selectedExercises = selectedExercises;
        // Initialize other fields as needed
    }

    @Override
    public String toString() {
        // Create a string representation of the workout session
        // Include user information, selected exercises, and other details
        return "Workout Session for " + user.getUsername() + "\nExercises: " + selectedExercises;
    }
}