package com.siifi.infos.entity;

import java.io.Serializable;

public class Honey implements Serializable {
    private int honeyId;
    private String honeyName;
    private String utter;
    private String shou;
    private String date;

    private String imagePath;

    public int getHoneyId() {
        return honeyId;
    }

    public void setHoneyId(int honeyId) {
        this.honeyId = honeyId;
    }

    public String getHoneyName() {
        return honeyName;
    }

    public void setHoneyName(String honeyName) {
        this.honeyName = honeyName;
    }

    public String getUtter() {
        return utter;
    }

    public void setUtter(String utter) {
        this.utter = utter;
    }

    public String getShou() {
        return shou;
    }

    public void setShou(String shou) {
        this.shou = shou;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
