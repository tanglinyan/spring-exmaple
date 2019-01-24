package net.se.user.common;

import net.se.common.utils.DESUtil;
import net.se.common.utils.MD5;
import net.se.user.entity.UserDo;
import net.se.user.entity.UserPo;

public class UserManager {
    /**
     * check password
     * **/
    public static boolean matchingLogin(UserPo userPo, UserDo userDo){
        String salt = userPo.getSalt();
        String ciphertext = userPo.getPassword();
        //custom password
        String real_text =  userDo.getPassword();
        //local password
        String local_pwd = DESUtil.decryption(ciphertext, userPo.getSalt());
        //custom password
        String custom_pwd = MD5.getMD5(real_text);
        if(local_pwd.equals(custom_pwd)){
            return true;
        }
        return false;
    }
    /**
     * UserDo to UserPo
     * **/
    public static UserPo toUserPo(UserDo userDo){
        UserPo userPo = new UserPo();
        userPo.setUserName(userDo.getUserName());
        String salt = DESUtil.KeyCreate(32);
        String md5 = MD5.getMD5(userDo.getPassword());
        String text = DESUtil.encryption(md5,salt);
        userPo.setPassword(text);
        userPo.setSalt(salt);
        return userPo;
    }

}
