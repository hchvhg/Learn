package com.zk.service;

import java.util.Map;

public interface IUserService {
    /**
     * 根据id查询user
     * @param id
     * @return
     */
    public Map<String,Object> getUserById(String id);
}
