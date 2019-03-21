package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.User;
import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @RequestMapping("/regist")
    public String regist(User u){
        service.regist(u);
        return "login";
    }
    @RequestMapping("/login")
    public String login(User u, Model m){
        String err = service.login(u);
        if(err==null){
            return "success";
        }else{
            m.addAttribute("err",err);
        }
        return "login";
    }
}
