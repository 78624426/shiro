package s7;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test2 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String pass = "admin";
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[]arr = md.digest(pass.getBytes());
        System.out.println(new String(arr));
        //使用base64进行编码，以方便存储
        BASE64Encoder ec=new BASE64Encoder();
        System.out.println("加密后的字符串："+ec.encode(arr));
    }
}
