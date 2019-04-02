package com.siifi.infos.mapper;


import com.siifi.infos.entity.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    User findUser(String userName);
    void edit(User user);
}
