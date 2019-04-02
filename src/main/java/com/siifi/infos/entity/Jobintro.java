package com.siifi.infos.entity;

import java.io.Serializable;

public class Jobintro implements Serializable {
    private int jobintroId;

    public int getJobintroId() {
        return jobintroId;
    }

    public void setJobintroId(int jobintroId) {
        this.jobintroId = jobintroId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;
}
