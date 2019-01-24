package net.se.user.impl;

import net.se.user.entity.UserPo;
import net.se.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

@ContextConfiguration("classpath*:/application-context.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Test
    public void findUserByUserName() {
        UserPo userPo = null;
        try {
            userPo = userService.findUserByUserName("admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(userPo.getUserName(),"admin");
    }
}
