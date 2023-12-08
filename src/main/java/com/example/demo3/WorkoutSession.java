package com.example.demo3;

import java.util.List;

//Class was barely used

public class WorkoutSession {

    private final UserProfile user;
    private final List<String> selectedExercises;


    public WorkoutSession(UserProfile user, List<String> selectedExercises) {
        this.user = user;
        this.selectedExercises = selectedExercises;
        
    }

    @Override
    public String toString() {
        return "Workout Session for " + user.getUsername() + "\nExercises: " + selectedExercises;
    }
}