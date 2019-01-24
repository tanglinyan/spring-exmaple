package net.se.user.impl;

import net.se.loginlog.dao.LoginLogDao;
import net.se.loginlog.entity.LoginLog;
import net.se.user.common.UserManager;
import net.se.user.dao.UserDao;
import net.se.user.entity.UserDo;
import net.se.user.entity.UserPo;
import net.se.user.exception.PasswordAuthException;
import net.se.user.exception.UserNotFoundException;
import net.se.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * user service impl
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private LoginLogDao loginLogDao;

    /**
     * init LoginLogDao
     **/
    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    /**
     * init UserDao
     **/
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * register user
     **/
    @Override
    public void register(UserDo userDo) {
        UserPo userPo = UserManager.toUserPo(userDo);
        userDao.insert(userPo);
    }

    /**
     * user login
     **/
    @Override
    @Transactional
    public UserPo login(UserDo userDo) throws UserNotFoundException, PasswordAuthException {
        if (userDo == null) {
            throw new NullPointerException();
        }
        UserPo userPo = findUserByUserName(userDo.getUserName());
        if (userPo == null) {
            throw new UserNotFoundException();
        }
        boolean isLogin = UserManager.matchingLogin(userPo, userDo);
        if (!isLogin) {
            throw new PasswordAuthException();
        }
        updateLoginInfo(userPo);
        return userPo;
    }

    /**
     * update Login Info
     **/
    @Override
    @Transactional
    public void updateLoginInfo(UserPo userPo) {
        LoginLog LoginLog = new LoginLog();
        LoginLog.setIp(userPo.getLastIp());
        LoginLog.setUserId(userPo.getUserId());
        LoginLog.setLoginDate(new Date());
        //update user info
        userDao.updateLoginInfo(userPo);
        //insert login log
        loginLogDao.insretLog(LoginLog);
    }

    /**
     * find user by userName
     **/
    @Override
    public UserPo findUserByUserName(String userName) {
        return userDao.findUserByUserName(userName);
    }

}
