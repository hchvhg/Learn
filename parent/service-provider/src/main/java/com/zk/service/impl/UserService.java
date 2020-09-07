package com.zk.service.impl;

import com.zk.mapper.UserMapper;
import com.zk.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Map<String, Object> getUserById(String id) {
        Map<String, Object> userMap = userMapper.getUserById(id);
        return userMap;
    }
}
