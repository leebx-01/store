package com.leebx.controller;

import com.leebx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/user-web")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/login")
    public String login(String username, String password, ModelMap modelMap, HttpSession session){
        String url = "http://user-service/user/login?username="+username+"&password="+password;
        User user = restTemplate.getForObject(url, User.class);
        session.setAttribute("user",user);
        if(user.getState().equals("0")){
            return "login";
        }
        modelMap.put("user",user);

        return "redirect:/web/getList";
    }
    @RequestMapping("/regist")
    public String regist(User user,String emily){
        user.setCreated(new Date());
        String url = "http://user-service/user/regist?id="+0+"&username="+user.getUsername()+"&password="+user.getPassword()+"&phone="+user.getPhone()+"&created="+user.getCreated()+"&emily="+emily;
        restTemplate.getForObject(url,Object.class);
        return "login";
    }

}
