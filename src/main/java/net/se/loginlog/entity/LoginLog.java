package net.se.loginlog.entity;

import org.springframework.stereotype.Repository;

import java.util.Date;
/**
 * login log
 * **/
@Repository
public class LoginLog {
    public LoginLog(){
        System.out.println("LoginLog=========================>>>");
    }
    private int loginlogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public int getLoginlogId() {
        return loginlogId;
    }

    public void setLoginlogId(int loginlogId) {
        this.loginlogId = loginlogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
