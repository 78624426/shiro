package s3;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

public class R2 implements Realm{
    @Override
    /*返回realm名字，随便写，认证时，用来判断使用的是哪一个realm通过了本次认证*/
    public String getName() {
        return "ream2";
    }

    @Override
    //用于判断用户传来的token是否被当前realm支持
    public boolean supports(AuthenticationToken t) {
        return t instanceof UsernamePasswordToken;
    }

    @Override
    //认证过程
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken t) throws AuthenticationException {
        /*获取用户输入的用户名及密码*/
        String name = (String)t.getPrincipal();
        String pass = new String((char[])t.getCredentials());
        if(!"admin".equals(name)){
            throw new UnknownAccountException("用户名出错");
        }

        if(!"1234".equals(pass)){
            throw new IncorrectCredentialsException("密码错误");
        }
        return new SimpleAuthenticationInfo(name,pass,getName());
    }
}
