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
        exercises.add(new Exercise("Plank", "A core-strengthening exercise that involves holding a push-up position with the body in a straight line from head to heels."));
        exercises.add(new Exercise("Bicycle Crunch", "An abdominal exercise that targets the rectus abdominis and obliques by simulating a pedaling motion while lying on your back."));
        exercises.add(new Exercise("Lunges", "A lower body exercise that targets the quadriceps, hamstrings, and glutes by taking a step forward and bending both knees."));
        exercises.add(new Exercise("Pull-Up", "An upper body exercise that targets the back, biceps, and shoulders by lifting the body using an overhead bar."));
        exercises.add(new Exercise("Plank Shoulder Taps", "A core-strengthening exercise that involves holding a plank position and tapping each shoulder alternately with your hand."));
    ////////Second Set of exercises:
        exercises.add(new Exercise("Deadlift", "A compound weightlifting exercise that targets the lower back, hamstrings, and glutes by lifting a barbell or weights from the ground to a standing position."));
        exercises.add(new Exercise("Burpees", "A full-body exercise that combines a squat, push-up, and jump, providing a high-intensity cardiovascular workout."));
        exercises.add(new Exercise("Dumbbell Rows", "An upper body exercise that targets the back, specifically the latissimus dorsi muscles, by pulling dumbbells towards the hips."));
        exercises.add(new Exercise("Leg Raises", "An abdominal exercise that targets the lower abs by lifting the legs off the ground while lying on your back."));
        exercises.add(new Exercise("Tricep Dips", "An upper body exercise that targets the triceps by using a bench or parallel bars to dip the body up and down."));
        exercises.add(new Exercise("Russian Twists", "An abdominal exercise that targets the obliques by sitting on the floor and twisting the torso to touch the ground on each side."));
        exercises.add(new Exercise("Box Jumps", "A lower body plyometric exercise that involves jumping onto a box or platform, working on explosive leg power."));
    
    
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
