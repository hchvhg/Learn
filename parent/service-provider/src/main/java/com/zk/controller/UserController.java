package com.zk.controller;

import com.zk.service.IUserService;
import com.zk.util.ServerPortUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ServerPortUtil portUtil;
    @GetMapping("getUserById")
    public String getUserById(@RequestParam("id") String id){
        Map<String, Object> userMap = userService.getUserById(id);
        System.out.println(portUtil.getPort());
        return userMap.toString();
    }
}
