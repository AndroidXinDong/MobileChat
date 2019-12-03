package com.example.mobilechat.pagers;


import java.io.Serializable;

public class TempBean implements Serializable {
    private int imgID;
    private String name;
    private String tempMsg;
    private String date;

    public TempBean(int imgID, String name, String tempMsg, String date) {
        this.imgID = imgID;
        this.name = name;
        this.tempMsg = tempMsg;
        this.date = date;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempMsg() {
        return tempMsg;
    }

    public void setTempMsg(String tempMsg) {
        this.tempMsg = tempMsg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
