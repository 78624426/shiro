package servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String pass = req.getParameter("pass");
        UsernamePasswordToken tok=new UsernamePasswordToken(name,pass);
        Subject sub = SecurityUtils.getSubject();

        try{
            sub.login(tok);
            //req.setAttribute("name",name);
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
        }catch (Exception e){
            req.setAttribute("msg","用户名或密码错误");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }
}
