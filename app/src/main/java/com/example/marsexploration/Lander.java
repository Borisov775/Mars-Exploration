package com.example.marsexploration;

public class Lander implements Spacecraft {
    private String nicePhoto;
    private String emblem;
    private String name;
    private String DateOfArriving;
    private String imageURL;
    private String flag;
    private String Mode;
    private String operator;
    private String durationOfMission;
    private String orbitDebris;
    private String pressKit;
    private String ImagesData;
    private String pageURL;
    public Lander(String name, String dateOfLanding, String imageURL, String mode, String durationOfMission,
                     String operator,String pageURL,String orbitDebris,String pressKit,String ImagesData,String flag,String emblem,
                  String nicePhoto) {
        this.emblem=emblem;
        this.name = name;
        this.DateOfArriving = dateOfLanding;
        this.imageURL = imageURL;
        this.flag=flag;
        this.Mode = mode;
        this.operator=operator;
        this.durationOfMission=durationOfMission;
        this.pageURL=pageURL;
        this.orbitDebris=orbitDebris;
        this.pressKit=pressKit;
        this.ImagesData=ImagesData;
        this.nicePhoto=nicePhoto;


    }
    @Override
    public String getDateOfLanding() {
        return null;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfArriving() {
        return DateOfArriving;
    }

    public void setDateOfArriving(String dateOfArriving) {
        DateOfArriving = dateOfArriving;
    }

    @Override
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getMode() {
        return Mode;
    }

    public void setMode(String mode) {
        Mode = mode;
    }

    @Override
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String getDurationOfMission() {
        return durationOfMission;
    }

    public void setDurationOfMission(String durationOfMission) {
        this.durationOfMission = durationOfMission;
    }

    public String getOrbitDebris() {
        return orbitDebris;
    }

    public void setOrbitDebris(String orbitDebris) {
        this.orbitDebris = orbitDebris;
    }

    public String getPressKit() {
        return pressKit;
    }

    public void setPressKit(String pressKit) {
        this.pressKit = pressKit;
    }

    public String getImagesData() {
        return ImagesData;
    }

    public void setImagesData(String imagesData) {
        ImagesData = imagesData;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getNicePhoto() {
        return nicePhoto;
    }

    public void setNicePhoto(String nicePhoto) {
        this.nicePhoto = nicePhoto;
    }
}
