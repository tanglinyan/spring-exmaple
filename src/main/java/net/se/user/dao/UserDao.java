package net.se.user.dao;

import net.se.user.entity.UserPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserPo Dao
 **/
@Repository
public class UserDao {
    /**
     * table t_user SQL
     **/
    private static final String TABLE = "t_user";
    //Connection
    private JdbcTemplate jdbcTemplate;

    /**
     * set init
     **/
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * find user number by username and password
     **/
    public int getMatchCount(String username, String password) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(1) from ");
        builder.append(TABLE);
        builder.append(" where user_name = ? and password = ?");
        return jdbcTemplate.queryForObject(builder.toString(), new Object[]{username, password}, Integer.class);
    }
    /**
     * insert into User
     * **/
    public void insert(UserPo userPo) {
        StringBuilder builder = new StringBuilder();
        builder.append("insert into ");
        builder.append(TABLE);
        builder.append("(user_name,password,credits,last_visit,last_ip) values(?,?,?,?,?)");
        Object[] args = new Object[]{userPo.getUserName(), userPo.getPassword(), userPo.getCredits(), userPo.getLastVisit(), userPo.getLastIp()};
        jdbcTemplate.update(builder.toString(), args);
    }

    /**
     * find userinfo by username
     **/
    public UserPo findUserByUserName(final String userName) {
        StringBuilder builder = new StringBuilder();
        builder.append("select user_id,user_name,credits from ");
        builder.append(TABLE);
        builder.append(" where user_name = ?");
        final UserPo user = new UserPo();
        jdbcTemplate.query(builder.toString(), new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    /**
     * update login log
     **/
    public void updateLoginInfo(UserPo userPo) {
        StringBuilder builder = new StringBuilder();
        builder.append("update ");
        builder.append(TABLE);
        builder.append(" set last_visit=?,last_ip=?,credits=? where user_id=?");
        jdbcTemplate.update(builder.toString(), new Object[]{userPo.getLastVisit(), userPo.getLastIp(), userPo.getCredits(), userPo.getUserId()});
    }
}
