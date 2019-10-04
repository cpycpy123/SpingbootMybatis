package com.cpy.springbootdemo.controller;

import com.cpy.springbootdemo.entity.User;
import com.cpy.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    //跳转首页（登录页）
    @RequestMapping("/toIndex")
    public String show(){
        return "login";
    }

    //登录操作
    @ResponseBody
    @RequestMapping("/loginUser")
    public String login(User user, HttpServletRequest request){
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        User u1 =userService.login(userName,passWord);
        if (u1==null){
            return "用户名或密码错误";
        }else{
            request.getSession().setAttribute("session_user",user);//登录成功后将用户放入session中，用于拦截
            return "登录成功";
        }
    }

    //跳转注册页
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    //注册操作
    @RequestMapping("/register")
    public String register(User user){
        int su = userService.register(user);
        if(su==0){
            System.out.println("----");
        }
        return "wel";
    }

    //测试未登陆拦截页面
    @RequestMapping("/welcome")
    public String welcome(){
        return "wel";
    }

    //退出登录
    @RequestMapping("/outUser")
    public void outUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("session_user");
        response.sendRedirect("/user/toIndex");
    }

}
