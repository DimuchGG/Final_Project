package com.nanddgroup.myapplication;

/**
 * Created by Dimuch on 16.07.2016.
 */
public class Friend {

    private String sName;
    private int imageID;
    private Boolean status;
    private MyFragment myFragment;

    public Friend(String sName, int imageID) {
        this.sName = sName;
        this.imageID = imageID;
        this.status = false;
        this.myFragment = new MyFragment();
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public MyFragment getMyFragment() {
        return myFragment;
    }

    public void setMyFragment(MyFragment myFragment) {
        this.myFragment = myFragment;
    }
}
