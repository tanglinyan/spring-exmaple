package net.se.loginlog.service;

import net.se.loginlog.entity.LoginLog;
import org.springframework.stereotype.Service;
/**
 * login log service
 * **/
@Service
public interface LoginLogService {
    /**
     * insert log
     * **/
    public void insretLog(LoginLog loginLog);
}
