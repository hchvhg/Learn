package com.zk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    public Map<String,Object> getUserById(@Param("id") String id);
}
