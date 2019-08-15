package com.leebx.controller;

import com.leebx.pojo.MailUtil;
import com.leebx.pojo.User;
import com.leebx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public User login(String username, String password){
        User user = userService.login(username, password);
        if(user==null&&user.equals("")){
            return null;
        }
        return user;
    }
    @RequestMapping("/regist")
    public void regist(User user,String code,String emily){
        user.setCode(UUID.randomUUID().toString());
        user.setState("0");
        userService.register(user);
        User user1 = userService.login(user.getUsername(),user.getPassword());
        MailUtil.sendMail(emily,user.getCode(),user1.getUsername(),user1.getPassword());
    }
    @RequestMapping("/activate")
    public String activate(String username,String password,String code){
        User user1 = userService.login(username,password);
        if(user1.getCode().equals(code)){
            //修改状态号
            userService.updateState("1",user1.getId());
            return "激活成功";
        }else{
            return "激活失败";
        }
    }
}
