package com.example.yanzhengcookiedengluzhuangtai.dao;

import com.example.yanzhengcookiedengluzhuangtai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    List<User> login(@Param("username") String username,@Param("password") String password);
}
