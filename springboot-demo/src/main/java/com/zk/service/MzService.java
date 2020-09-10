package com.zk.service;

import java.util.Map;

/**
 * 门诊操作service接口类
 *
 * @author zk
 * @date 2020-9-9
 */
public interface MzService {
    /**
     * 挂号方法
     *
     * @return
     */
    Map<String, Object> gh(String ksdm, String ysdm, String brid);
}
