package util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

public class PassUtil {
    public static String encode(String pass,String salt){
        //实现加盐值的md5算法
        Md5Hash md = new Md5Hash(pass,salt);
        return md.toString();
    }

    public static String randomSalt() {
        SecureRandomNumberGenerator gen = new SecureRandomNumberGenerator();
        ByteSource nb = gen.nextBytes();
        return new String(nb.getBytes());
    }

    public static void main(String[] args) {
        System.out.println(randomSalt());
    }
}
