package com.example.marsexploration;

import androidx.annotation.NonNull;

import java.net.URL;

public class Rover {
    private String name;
    private String DateOfLanding;
    private String imageURL;
    private String Mode;
    private String operator;
    private String durationOfMission;
    private String pageURL;
    private String currentLocation;

    public Rover(String name, String dateOfLanding, String imageURL, String mode, String durationOfMission, String operator, String pageURL,String currentLocation) {
        this.name = name;
        this.DateOfLanding = dateOfLanding;
        this.imageURL = imageURL;
        this.Mode = mode;
        this.operator=operator;
        this.durationOfMission=durationOfMission;
        this.pageURL=pageURL;
        this.currentLocation=currentLocation;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "name='" + name + '\'' +
                ", DateOfLanding='" + DateOfLanding + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", Mode='" + Mode + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfLanding() {
        return DateOfLanding;
    }

    public void setDateOfLanding(String dateOfLanding) {
        DateOfLanding = dateOfLanding;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDurationOfMission() {
        return durationOfMission;
    }

    public void setDurationOfMission(String durationOfMission) {
        this.durationOfMission = durationOfMission;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
}
