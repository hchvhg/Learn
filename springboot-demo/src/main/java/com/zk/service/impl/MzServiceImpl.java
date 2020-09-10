package com.zk.service.impl;

import com.zk.mapper.MzMapper;
import com.zk.service.MzService;
import com.zk.util.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 门诊操作service实现类
 *
 * @author zk
 * @date 2020-9-9
 */
@Service
public class MzServiceImpl implements MzService {
    @Autowired
    private MzMapper mzMapper;
    @Autowired
    private RedisLock redisLock;

    @Override
    public Map<String, Object> gh(String ksdm, String ysdm, String brid) {
        Map<String, Object> resultMap = new HashMap<>();
        int ghxh = 0;
        //加锁操作
        String token = null;
        token = redisLock.lock("gh", 3000,3500);
        try {
            //获取到了锁,执行正常业务
            if (token != null) {
                //获取当前的挂号序号
                Map<String, Object> ghxhMap = mzMapper.getGhxh(ksdm, ysdm);
                //如果为空,说明还没有人挂这个医生的号,当前是一号
                if (ghxhMap == null) {
                    ghxh = 1;
                } else {
                    ghxh = (int) ghxhMap.get("GHXH");
                    ghxh++;
                }
                //实际场景中,先获取到ghxh后,还会进行收费等其他操作,这里模拟一下需要耗费时间,为了方便测试出现问题,这里时间设置稍微长一点
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //新增挂号明细记录
                mzMapper.addGhmx(ksdm, ysdm, ghxh, brid);
            } else {
                resultMap.put("code", "401");
                resultMap.put("msg", "其他窗口正在操作,请稍后再试");
                return resultMap;
            }
        } finally {
            //解锁
            if (token != null) {
                boolean gh = redisLock.unlock("gh", token);
            }
        }
        resultMap.put("code", "200");
        resultMap.put("msg", "success");
        return resultMap;
    }
}
