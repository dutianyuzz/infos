package com.siifi.infos.entity;

import java.io.Serializable;

public class Tid implements Serializable {
    private int id;
    private String tid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

}
