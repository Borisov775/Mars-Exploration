package com.example.marsexploration;

public class Satellite implements Spacecraft{
    private String name;
    private String DateOfArriving;
    private String imageURL;
    private String Mode;
    private String operator;
    private String durationOfMission;
    public Satellite(String name, String dateOfLanding, String imageURL, String mode, String durationOfMission,
                 String operator) {
        this.name = name;
        this.DateOfArriving = dateOfLanding;
        this.imageURL = imageURL;
        this.Mode = mode;
        this.operator=operator;
        this.durationOfMission=durationOfMission;
        
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfLanding() {
        return DateOfArriving;
    }

    public void setDateOfLanding(String dateOfLanding) {
        DateOfArriving = dateOfLanding;
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
}
