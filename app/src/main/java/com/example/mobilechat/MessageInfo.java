package com.example.mobilechat;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MessageInfo implements Serializable {
    public String msg;
    private String date;
    private int type;
    private int touxaign;

    public MessageInfo(String msg, String date, int type, int touxaign) {
        this.msg = msg;
        this.date = date;
        this.type = type;
        this.touxaign = touxaign;
    }

    public int getTouxaign() {
        return touxaign;
    }

    public void setTouxaign(int touxaign) {
        this.touxaign = touxaign;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
