package com.siifi.infos.mapper;

import com.siifi.infos.entity.Invite;
import com.siifi.infos.entity.Jobintro;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InviteMapper {
    @Select("select INVITE_ID,INVITE_NAME,PERSON_NAME,DATE,INVITE_TEXT from sys_invite")
    List<Invite> listAll();
    Invite findById(int inviteId);
    int save(Invite invite);
    int edit(Invite invite);
    int delete(int inviteId);
    Jobintro findJobById(int jobintroId);
    int editJob(Jobintro jobintro);
}
