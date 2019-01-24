package net.se.user.service;

import net.se.user.entity.UserDo;
import net.se.user.entity.UserPo;

/**
 * user Service
 **/

public interface UserService {
    /**
     * register User
     **/
    public void register(UserDo userDo);

    /**
     * user login
     **/
    public UserPo login(UserDo userDo);

    /**
     * update Login Info
     **/
    public void updateLoginInfo(UserPo userPo);

    /**
     * find user by userName
     **/
    public UserPo findUserByUserName(String userName);
}
