package com.siifi.infos.entity;

import java.io.Serializable;

public class Invite implements Serializable {
    private int inviteId;
    private String inviteName;
    private String personName;
    private String date;
    private String inviteText;

    public int getInviteId() {
        return inviteId;
    }

    public void setInviteId(int inviteId) {
        this.inviteId = inviteId;
    }

    public String getInviteName() {
        return inviteName;
    }

    public void setInviteName(String inviteName) {
        this.inviteName = inviteName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInviteText() {
        return inviteText;
    }

    public void setInviteText(String inviteText) {
        this.inviteText = inviteText;
    }

}
