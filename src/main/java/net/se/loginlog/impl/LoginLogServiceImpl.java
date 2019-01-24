package net.se.loginlog.impl;

import net.se.loginlog.dao.LoginLogDao;
import net.se.loginlog.entity.LoginLog;
import net.se.loginlog.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * login log service impl
 **/
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {

    private LoginLogDao loginLogDao;

    /**
     * init LoginLogDao
     **/
    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
    /**
     * inster log
     * **/
    @Override
    public void insretLog(LoginLog loginLog) {
        loginLogDao.insretLog(loginLog);
    }
}
