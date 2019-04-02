package com.siifi.infos.entity;

import java.io.Serializable;

public class Msc implements Serializable {
    private int mscId;
    private String mscName;
    private String shou;
    private String content;

    public int getMscId() {
        return mscId;
    }

    public void setMscId(int mscId) {
        this.mscId = mscId;
    }

    public String getMscName() {
        return mscName;
    }

    public void setMscName(String mscName) {
        this.mscName = mscName;
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
