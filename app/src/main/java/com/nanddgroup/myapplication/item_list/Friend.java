package com.nanddgroup.myapplication.item_list;

/**
 * Created by Dimuch on 16.07.2016.
 */
public class Friend {

    private String sName;
    private int imageID;

    public Friend(String sName, int imageID) {
        this.sName = sName;
        this.imageID = imageID;
    }

    public String getsName() {
        return sName;
    }

    public int getImageID() {
        return imageID;
    }

}
