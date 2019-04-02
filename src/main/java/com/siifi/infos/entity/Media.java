package com.siifi.infos.entity;
import java.io.Serializable;

public class Media implements Serializable {
    private int mediaId;
    private String mediaName;
    private String shou;
    private String content;

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
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
