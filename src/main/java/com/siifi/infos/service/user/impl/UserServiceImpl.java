package com.siifi.infos.service.user.impl;

import com.siifi.infos.entity.User;
import com.siifi.infos.mapper.UserMapper;
import com.siifi.infos.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User getUser(String userName) {
        return userMapper.findUser(userName);
    }
    public void editUser(User user){
        userMapper.edit(user);
    }
}
