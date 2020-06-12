package com.example.yanzhengcookiedengluzhuangtai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/h")
public class Index {
    @RequestMapping("/html")
   // @ResponseBody
    public String getHtml(){
        return "login";
    }
}
