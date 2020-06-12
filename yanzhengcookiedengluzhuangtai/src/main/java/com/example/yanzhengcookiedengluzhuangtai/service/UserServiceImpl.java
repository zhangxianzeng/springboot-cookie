package com.example.yanzhengcookiedengluzhuangtai.service;

import com.example.yanzhengcookiedengluzhuangtai.dao.UserDao;
import com.example.yanzhengcookiedengluzhuangtai.pojo.User;
import com.example.yanzhengcookiedengluzhuangtai.util.CookieUtils;
import com.example.yanzhengcookiedengluzhuangtai.util.MD5Util;
import com.example.yanzhengcookiedengluzhuangtai.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Result login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
Result result=new Result();
        try {
if(username!=null&&password!=null&&username!=""&&password!=""){
    String pwd= MD5Util.string2MD5(password);
    List<User> user1=userDao.login(username,pwd);
if(user1.isEmpty()){
    result.setMsg("用户名或密码错误");
}else{

    User user2=new User();
    user2.setUsername(username);
    user2.setPassword(pwd);
    result.setMsg("登录成功");
    result.setSuccess(true);
    result.setDetail(user2);
    CookieUtils.setCookie(request, response, "JT_TICKET4", user2.getUsername());

}

}else {
    result.setMsg("用户名密码不能为空");
}
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
return result;
    }








}
