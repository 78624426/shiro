package s1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
/*注意：用的一定是shiro包下的Sm,不能使用java.lang包下的东西*/
import org.apache.shiro.mgt.SecurityManager;


public class Test {
    public static void main(String[] args) {
        Factory<SecurityManager>factory = new IniSecurityManagerFactory("classpath:s1/s1.ini");
        //获取安全管理器
        SecurityManager sm = factory.getInstance();

        //把安全管理器交给shiro的工具类
        SecurityUtils.setSecurityManager(sm);

        //Subject获取
        Subject sub = SecurityUtils.getSubject();

        System.out.println("用户是否已经登录？"+sub.isAuthenticated());

        UsernamePasswordToken t = new UsernamePasswordToken("admin","123");
        try{
            sub.login(t);
            System.out.println(sub.isAuthenticated());
        }catch (UnknownAccountException e){
            System.out.println("帐号出错");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }

        sub.logout();//退出认证
        System.out.println("用户是否已经登录？"+sub.isAuthenticated());
    }
}
