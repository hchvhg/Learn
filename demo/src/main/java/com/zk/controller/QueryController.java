package com.zk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {
    @GetMapping("/wlcs")
    public String test(){
        return "网络测试。。。";
    }
}
