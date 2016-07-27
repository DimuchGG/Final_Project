package com.nanddgroup.myapplication.item_list;


import java.util.Calendar;

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
        this.time = formatTime();
        this.imageID = imageID;
        this.itIsMe = itIsMe;
    }

    private String formatTime() {
        int iHour = calendar.get(Calendar.HOUR_OF_DAY);
        int iMin = calendar.get(Calendar.MINUTE);
        String sHour = String.valueOf(iHour);
        String sMin = String.valueOf(iMin);
        if ( iHour < 10 ) {
            sHour = "0" + String.valueOf(iHour);
        }
        if ( iMin < 10 ) {
            sMin = "0" + String.valueOf(iHour);
        }
        return sHour + ":" + sMin;
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
