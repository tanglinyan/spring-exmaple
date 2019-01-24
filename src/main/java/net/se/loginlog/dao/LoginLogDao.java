package net.se.loginlog.dao;

import net.se.loginlog.entity.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * user login log
 **/
@Repository
public class LoginLogDao {

    /**
     * table t_user SQL
     **/
    private static final String TABLE = "t_login_log";

    private JdbcTemplate jdbcTemplate;
    /**
     * set init
     * **/
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /**
     * insert login log
     * **/
    public void insretLog(LoginLog loginLog){
        StringBuilder builder = new StringBuilder();
        builder.append("insert into ");
        builder.append(TABLE);
        //TODO insert date can not is date type
        builder.append("(user_id,ip,login_datetime) value(?,?,?)");
        Object[] args = new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate()};
        jdbcTemplate.update(builder.toString(),args);
    }
}
