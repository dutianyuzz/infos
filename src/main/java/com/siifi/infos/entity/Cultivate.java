package com.siifi.infos.entity;

import java.io.Serializable;

public class Cultivate implements Serializable {
    private int cultivateId;
    private String cultivateName;
    private String shou;
    private String content;

    public int getCultivateId() {
        return cultivateId;
    }

    public void setCultivateId(int cultivateId) {
        this.cultivateId = cultivateId;
    }

    public String getCultivateName() {
        return cultivateName;
    }

    public void setCultivateName(String cultivateName) {
        this.cultivateName = cultivateName;
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
