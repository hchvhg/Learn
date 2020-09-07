package com.zk.controller;

import com.zk.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryDataController {
    @Autowired
    private UserClient userClient;
    @GetMapping("/getUser")
    public String getUser(@RequestParam("id") String id){
        return userClient.getUserById(id);
    }
}
