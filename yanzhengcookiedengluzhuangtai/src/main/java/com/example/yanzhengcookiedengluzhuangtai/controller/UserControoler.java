package com.example.yanzhengcookiedengluzhuangtai.controller;

import com.example.yanzhengcookiedengluzhuangtai.pojo.User;
import com.example.yanzhengcookiedengluzhuangtai.service.UserService;
import com.example.yanzhengcookiedengluzhuangtai.util.CookieUtils;
import com.example.yanzhengcookiedengluzhuangtai.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserControoler {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public Result login(User user, HttpServletRequest request, HttpServletResponse response) {


        return userService.login(user.getUsername(),user.getPassword(), request, response);
    }


    @RequestMapping("/getcookie")
    public String getCookie(HttpServletRequest request){
        return CookieUtils.getCookieValue(request,"JT_TICKET4");
    }
//cookie换了浏览器一样可以获取到，只需要判断JT_TICKET这个名字是不是在以前存过到数据中就行
    @RequestMapping("/getcookie1")
    public String getCookie1(HttpServletRequest request){
        return CookieUtils.getCookieValue(request,"JT_TICKE");
    }

    @RequestMapping("/gettext")
    public String getCookie2(){
        return "查看是否有拦截";
    }

    @RequestMapping("/gettext1")
    public String getCookie3(){
        return "路径拦截";
    }
}