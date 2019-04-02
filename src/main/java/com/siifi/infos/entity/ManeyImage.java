package com.siifi.infos.entity;

import java.io.Serializable;

public class ManeyImage implements Serializable {
    private int maneyImageId;
    private String maneyId;
    private String tid;

    public int getManeyImageId() {
        return maneyImageId;
    }

    public void setManeyImageId(int maneyImageId) {
        this.maneyImageId = maneyImageId;
    }

    public String getManeyId() {
        return maneyId;
    }

    public void setManeyId(String maneyId) {
        this.maneyId = maneyId;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

}
