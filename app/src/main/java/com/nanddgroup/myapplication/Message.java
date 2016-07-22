package com.nanddgroup.myapplication;

/**
 * Created by Dimuch on 20.07.2016.
 */
public class Message {

    String name;
    String message;
    String time;
    int imageID;


    public Message(int imageID, String message) {
//        this.name = name;
        this.message = message;
        this.time = "00:00";
        this.imageID = imageID;

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
