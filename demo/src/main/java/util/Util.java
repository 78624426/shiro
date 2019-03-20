package util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class Util {
    public static void getConig(String config){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(config);
        SecurityManager sm = factory.getInstance();
        SecurityUtils.setSecurityManager(sm);
    }

    public static Subject login(String name, String pass){
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken t = new UsernamePasswordToken(name,pass);
        try{
            sub.login(t);
            System.out.println(sub.isAuthenticated());
        }catch (UnknownAccountException e){
            System.out.println("帐号出错");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (Exception e){
            System.out.println("认证出错");
        }
        return sub;
    }

    public static void logout(){
        Subject sub = SecurityUtils.getSubject();
        sub.logout();
    }
}
