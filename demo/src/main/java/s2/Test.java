package s2;

import org.apache.shiro.subject.Subject;
import util.Util;

public class Test {
    public static void main(String[] args) {
        Util.getConig("classpath:s2/s2.ini");
        Subject sub=Util.login("admin","1523");
        if(sub.isAuthenticated()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}
