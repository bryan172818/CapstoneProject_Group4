package com.example.demo3;



public class Activity {
	//Does not apply to all exercises
    private String type;
    private double duration; // in minutes
    private double distance; // in kilometers
    private int intensity; // scale of 1-10

   
    
    // Constructor
    public Activity(String type, double duration, double distance, int intensity) {
        this.type = type;
        this.duration = duration;
        this.distance = distance;
        this.intensity = intensity;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for duration
    public double getDuration() {
        return duration;
    }

    // Setter for duration
    public void setDuration(double duration) {
        this.duration = duration;
    }

    // Getter for distance
    public double getDistance() {
        return distance;
    }

    // Setter for distance
    public void setDistance(double distance) {
        this.distance = distance;
    }

    // Getter for intensity
    public int getIntensity() {
        return intensity;
    }

    // Setter for intensity
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }
}

