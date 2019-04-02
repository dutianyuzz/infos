package com.siifi.infos.entity;

import java.io.Serializable;

public class Zoology implements Serializable {
    private int zoologyId;
    private String zoologyName;
    private String shou;
    private String content;
    public int getZoologyId() {
        return zoologyId;
    }

    public void setZoologyId(int zoologyId) {
        this.zoologyId = zoologyId;
    }

    public String getZoologyName() {
        return zoologyName;
    }

    public void setZoologyName(String zoologyName) {
        this.zoologyName = zoologyName;
    }

    public String getShou() {
        return shou;
    }

    public void setShou(String shou) {
        this.shou = shou;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
