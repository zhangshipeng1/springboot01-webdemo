package com.zsp.boot.springboot01webdemo.controller;

import com.zsp.boot.springboot01webdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table")
    public String basic_table(){
        return "Tabel/basic_table";
    }
    @GetMapping("dynamic_table")
    public String dynamic_table(Model model){
        List<User> users=Arrays.asList(new User("aa","123")
                ,new User("bb","11w")
                ,new User("cc","123445"));
        model.addAttribute("users",users);
        return "Tabel/dynamic_table";
    }
    @GetMapping("responsive_table")
    public String responsive_table(){
        return "Tabel/responsive_table";
    }
    @GetMapping("editable_table")
    public String editable_table(){
        return "Tabel/editable_table";
    }
}
