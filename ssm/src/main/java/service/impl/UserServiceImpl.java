package service.impl;

import dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import service.UserService;
import sun.misc.BASE64Encoder;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao dao;
    @Override
    public void regist(User u) {
        handle(u);
        dao.insert(u);
    }

    @Override
    public String login(User u) {
       handle(u);
        UsernamePasswordToken t = new UsernamePasswordToken(u.getName(),u.getPass());
        Subject sub = SecurityUtils.getSubject();
        String err=null;
        try{
            sub.login(t);
        }catch (AuthenticationException e){
            e.printStackTrace();
            err = "用户名或密码错误";
        }
        return err;

    }
    void handle(User u){
        MessageDigest md;
        try {
            md=MessageDigest.getInstance("MD5");
            byte[]arr = md.digest(u.getPass().getBytes());
            BASE64Encoder ec = new BASE64Encoder();
            u.setPass(ec.encode(arr));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("密码加密出错："+e.getMessage());
        }
    }
}
