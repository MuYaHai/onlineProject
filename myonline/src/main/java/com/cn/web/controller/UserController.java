package com.cn.web.controller;

import com.cn.api.UserControllerApi;
import com.cn.pojo.Advice;
import com.cn.pojo.Result;
import com.cn.pojo.User;
import com.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: MuYaHai
 * Date: 2019/12/1, Time: 22:02
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/login")
    public Result login(String username,String password,String remember, HttpServletResponse response) {
        Result login = userService.login(username,password);
        if (login.isFlag()) {
            if (remember != null) {
                Cookie usernameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(60*60*24*365);
                passwordCookie.setMaxAge(60*60*24*365);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
            }
        }
        return login;
    }

    @Override
    @PostMapping("/put/advice")
    public Result advice(@RequestBody Advice advice, HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return userService.advice(advice, ip);
    }

    @Override
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    @Override
    @GetMapping("/getUserName/{}")
    public Result getUserName(@PathVariable("id") String id) {
        return userService.getUserName(id);
    }

    @GetMapping("/getUserInfo")
    public Result register(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        User user = new User();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    user.setUsername(cookie.getValue());
                }
                if ("password".equals(cookie.getName())) {
                    user.setPassword(cookie.getValue());
                }
            }
        }
        return new Result(true, null, user);
    }
}
