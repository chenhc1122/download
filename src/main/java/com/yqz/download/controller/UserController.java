package com.yqz.download.controller;


import com.yqz.download.pojo.Result;
import com.yqz.download.pojo.User;
import com.yqz.download.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
        @Autowired
       private UserService userService;

    @PostMapping(value = "/regist")
    public Result regist(User user){
        return userService.regist(user);
    }

    @PostMapping(value = "/login")
    public Result login(User user,String username,String password){
        return userService.login(user,username,password);
    }

    @RequestMapping("/loginPage")
    public String html(ModelAndView model){
        System.out.println("------login------");
        return "login";
    }

}
