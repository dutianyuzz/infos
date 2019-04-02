package com.siifi.infos.service.user;

import com.siifi.infos.entity.User;

public interface UserService {
    User getUser(String userName);
    void editUser(User user);

}
