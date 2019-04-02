package com.siifi.infos.entity;

import java.io.Serializable;

public class ManeysImage implements Serializable {
    private int maneyId;

    public int getManeyId() {
        return maneyId;
    }

    public void setManeyId(int maneyId) {
        this.maneyId = maneyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
