package com.example.yanzhengcookiedengluzhuangtai.service;

import com.example.yanzhengcookiedengluzhuangtai.pojo.User;
import com.example.yanzhengcookiedengluzhuangtai.util.Result;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    Result login(String username, String password, HttpServletRequest request, HttpServletResponse response);
}
