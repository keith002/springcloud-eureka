package com.csdn.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csdn.entity.User;

@RestController
public class MyRestController {

    public static boolean isDB = true;

    @GetMapping(value = "/setIsDB/{isDB}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void setIsDB(@PathVariable boolean isDB) {
        this.isDB = isDB;
    }

    @GetMapping(value = "/getUser/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request){
        User user = new User();
        user.setId(id);
        user.setUsername("Keith");
        user.setPassword("123456");
        user.setPort(request.getRequestURL().toString());
        return user;
    }
    
    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String hello(HttpServletRequest request){
        return "Hello world!!!";
    }
}
