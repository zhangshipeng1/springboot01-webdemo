package com.zsp.boot.springboot01webdemo.controller;

import com.zsp.boot.springboot01webdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
@GetMapping(value = {"/","/login"})
    public String loginPage(){
      return  "login";
    }
    @PostMapping(value = "/login")
    public String main(User user, Model model, HttpSession session){
        if(StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassWord()) && StringUtils.hasLength(user.getPassWord()))
        {
            session.setAttribute("user",user);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","你的账户密码错误！");
            return "/login";
        }

    }
    @GetMapping(value ="/main.html")
    public String mainPage(HttpSession session,Model model){
    User user= (User) session.getAttribute("user");
    if(user!=null) {
        return "main";
        }else {
        model.addAttribute("msg","请重新登录！");
        return "login";
    }

    }

}
