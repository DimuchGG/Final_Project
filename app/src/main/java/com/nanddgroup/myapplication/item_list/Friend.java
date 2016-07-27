package com.nanddgroup.myapplication.item_list;

/**
 * Created by Dimuch on 16.07.2016.
 */
public class Friend {

    private String sName;
    private int imageID;
    private Profile profile;

    public Friend(Profile profile) {
        this.sName = profile.getsName();
        this.imageID = profile.getImageID();
        this.profile = profile;
    }

    public String getsName() {
        return sName;
    }

    public Profile getProfile() {
        return profile;
    }

    public int getImageID() {
        return imageID;
    }

}
