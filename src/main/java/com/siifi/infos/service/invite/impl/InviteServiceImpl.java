package com.siifi.infos.service.invite.impl;

import com.siifi.infos.entity.Invite;
import com.siifi.infos.entity.Jobintro;
import com.siifi.infos.mapper.InviteMapper;
import com.siifi.infos.service.invite.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InviteServiceImpl implements InviteService {
    @Autowired
    private InviteMapper inviteMapper;
    public List<Invite> getInvite(){
        return inviteMapper.listAll();
    }
    public Invite getInviteById(int inviteId){
        return inviteMapper.findById(inviteId);
    }
    public int saveInvite(Invite invite){
        return inviteMapper.save(invite);
    }

    public int editInvite(Invite invite){
        return inviteMapper.edit(invite);
    }
    public int deleteInvite(int inviteId){
        return inviteMapper.delete(inviteId);
    }
    public Jobintro getJobintroById(int jobintroId){
        return inviteMapper.findJobById(jobintroId);
    }
    public int editJobintro(Jobintro jobintro){
        return inviteMapper.editJob(jobintro);
    }
}
