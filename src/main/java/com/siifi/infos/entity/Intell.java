package com.siifi.infos.entity;

import java.io.Serializable;

public class Intell implements Serializable {
    private int intellId;
    private String intellName;
    private String shou;
    private String content;

    public int getIntellId() {
        return intellId;
    }

    public void setIntellId(int intellId) {
        this.intellId = intellId;
    }

    public String getIntellName() {
        return intellName;
    }

    public void setIntellName(String intellName) {
        this.intellName = intellName;
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
