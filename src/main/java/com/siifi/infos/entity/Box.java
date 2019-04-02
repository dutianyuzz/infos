package com.siifi.infos.entity;

import java.io.Serializable;

public class Box implements Serializable {

    private int intellId;  //智能产业
    private int zoologyId; //生态产业
    private int mediaId;   //文化传媒
    private int cultivateId;  //教育培训

    public int getIntellId() {
        return intellId;
    }

    public void setIntellId(int intellId) {
        this.intellId = intellId;
    }

    public int getZoologyId() {
        return zoologyId;
    }

    public void setZoologyId(int zoologyId) {
        this.zoologyId = zoologyId;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getCultivateId() {
        return cultivateId;
    }

    public void setCultivateId(int cultivateId) {
        this.cultivateId = cultivateId;
    }
}
