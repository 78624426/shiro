package s4;

import org.apache.shiro.subject.Subject;
import util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        Util.getConig("classpath:s4/s4.ini");
        Subject sub = Util.login("admin","123");
        //Subject sub = Util.login("root","123");
        System.out.println("当前登录用户拥有role1吗？"+sub.hasRole("role1"));
        List<String> c = new ArrayList<>();
        c.add("role1");
        c.add("role2");
        c.add("role3");
        System.out.println("当前用户是否包含集合中全部角色？"+sub.hasAllRoles(c));
        System.out.println(Arrays.toString(sub.hasRoles(c)));
    }
}
