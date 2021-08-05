package com.zsp.boot.springboot01webdemo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "Form/form_layouts";
    }
    @PostMapping("/form")
    public String fileUplond(@RequestParam("userName") String userName,
                             @RequestParam("email") String email,
                             @RequestPart("headerImg") MultipartFile headerImg,
                             @RequestPart("lifeImg") MultipartFile[]  lifeImg) throws IOException {
        log.info("上传的信息：email-{},userName-{},headimg-{},photos-{}",email,userName,headerImg,lifeImg.length);
if (!headerImg.isEmpty()){
String orgFile= headerImg.getOriginalFilename();
headerImg.transferTo(new File("D:\\cache\\"+orgFile));

}
if(lifeImg.length>0){
    for(MultipartFile multipartFile: lifeImg){
        if (!multipartFile.isEmpty()){
        String orgFile= multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\cache\\"+orgFile));
        }
    }
}
        return "main";

    }
}
