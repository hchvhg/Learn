package com.zk.client;

import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements  UserClient {
    @Override
    public String getUserById(String id) {
        return "服务出错了，请稍后访问";
    }
}
