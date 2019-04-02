package com.siifi.infos.entity;

import java.io.Serializable;

public class Dynamic implements Serializable {
    private int dynamicId;
    private String dynamicName;
    private String personName;
    private String sysDate;
    private String content;
    private int shou;

    public int getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(int dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getDynamicName() {
        return dynamicName;
    }

    public void setDynamicName(String dynamicName) {
        this.dynamicName = dynamicName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getShou() {
        return shou;
    }

    public void setShou(int shou) {
        this.shou = shou;
    }

}
