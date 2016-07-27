package com.nanddgroup.myapplication.item_list;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Dimuch on 20.07.2016.
 */
public class Message {

    private String name;
    private String message;
    private String time;
    private int imageID;
    private boolean itIsMe;

    private static Calendar calendar;


    public Message(int imageID, String message, boolean itIsMe) {
        calendar = Calendar.getInstance();

        this.message = message;
        this.time = (new SimpleDateFormat("HH:mm")).format(new Date(System.currentTimeMillis()));
        this.imageID = imageID;
        this.itIsMe = itIsMe;
    }

    public Message() {
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
