package com.siifi.infos.service.invite;

import com.siifi.infos.entity.Invite;
import com.siifi.infos.entity.Jobintro;

import java.util.List;

public interface InviteService {
    List<Invite> getInvite();
    Invite getInviteById(int inviteId);
    int saveInvite(Invite invite);
    int editInvite(Invite invite);
    int deleteInvite(int inviteId);
    Jobintro getJobintroById(int jobintroId);
    int editJobintro(Jobintro jobintro);
}
