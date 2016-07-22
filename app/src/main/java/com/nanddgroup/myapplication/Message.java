package com.nanddgroup.myapplication;

/**
 * Created by Dimuch on 20.07.2016.
 */
public class Message {

    private String name;
    private String message;
    private String time;
    private int imageID;
    private boolean itIsMe;


    public Message(int imageID, String message, boolean itIsMe) {
//        this.name = name;
        this.message = message;
        this.time = "00:00";
        this.imageID = imageID;
        this.itIsMe = itIsMe;
    }

    public boolean isItIsMe() {
        return itIsMe;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

}
