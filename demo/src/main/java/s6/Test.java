package s6;

import org.apache.shiro.subject.Subject;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Util.getConig("classpath:s6/s6.ini");
        Subject sub = Util.login("admin","123");
        //Subject sub = Util.login("root","123");
        System.out.println("当前登录用户拥有role1吗？"+sub.hasRole("r1"));
        List<String> c = new ArrayList<>();
        c.add("r1");
        c.add("r2");
        c.add("r3");
        System.out.println("当前用户是否包含集合中全部角色？"+sub.hasAllRoles(c));
        System.out.println(Arrays.toString(sub.hasRoles(c)));
        System.out.println("=========判断用户是否有某种权限=========");
        System.out.println("用户有权限person*？"+sub.isPermitted("person*"));

    }
}
