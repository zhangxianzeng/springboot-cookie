package com.example.yanzhengcookiedengluzhuangtai.util;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        boolean flag = false;
        String userName = "";
        // IOUtils.printDeBug("有用户进行访问");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                // IOUtils.printDeBug(cookie.getName() + ":" + cookie.getValue());
                if (cookie.getName().equals("JT_TICKET4")) {
                    userName = cookie.getValue();
                    // IOUtils.printDeBug("当前登录的用户为：" + userName);
                    request.getSession().setAttribute("JT_TICKET4", userName);
                    return  true;
                }
            }
           
        }
        //else{
            // IOUtils.printDeBug("当前用户状态：用户未登录");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("{code:0,message:\"not login!\"}");

            //  System.out.println("不存在cookie");
            return  false;
      //  }

//return flag;

    }



    /**
     * 当前请求进行处理之后，也就是Controller 方法调用之后执行，
     * 但是它会在DispatcherServlet 进行视图返回渲染之前被调用。
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }

}
