package s3;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import util.Util;

import java.util.Set;

public class Test {
    public static void main1(String[] args) {
        Util.getConig("classpath:s3/s3.ini");
        Subject sub=Util.login("admin","123");
        if(sub.isAuthenticated()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }

    public static void main(String[] args) {
        Util.getConig("classpath:s3/s3.ini");
        Subject sub=Util.login("admin","123");
        if(sub.isAuthenticated()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
        //获取通过认证的用户名
        PrincipalCollection c = sub.getPrincipals();
        System.out.println(c);
        //通过了哪些realm
        Set<String> names =  c.getRealmNames();
        System.out.println(names);
    }
}
