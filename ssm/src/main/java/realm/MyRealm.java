package realm;

import dao.UserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.User;
import util.PassUtil;

@Component
public class MyRealm extends AuthorizingRealm{
    public String getName(){
        return "myrealm";
    }
    @Autowired
    UserDao dao;
    /*用户授权处理，判断用户是否拥有某个角色或权限时会自动调用*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证过程
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken t) throws AuthenticationException {
        String name = (String)t.getPrincipal();//root
        String pass = new String((char[])t.getCredentials());//123
        User u = dao.selectUser(name);
        if(u==null){
            throw new UnknownAccountException("用户名不正确");
        }

        /*数据库中的密码*/
        String dbPass = u.getPass();
        String salt = u.getSalt();

        String tmp = PassUtil.encode(pass,salt);
        if(!tmp.equals(dbPass)){
            throw new IncorrectCredentialsException("密码错误");
        }

        return new SimpleAuthenticationInfo(name,pass,getName());
    }
}
