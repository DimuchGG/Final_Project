package com.nanddgroup.myapplication.item_list;

/**
 * Created by Dimuch on 26.07.2016.
 */
public class Profile {

    private String sName;
    private int imageID;
    private String status;
    private int age;
    private int sex;
    private String city;

    public String getsName() {
        return sName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setStatus(String status) {

        this.status = status;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
}
