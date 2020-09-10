package com.zk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 门诊mapper接口
 */
public interface MzMapper {
    /**
     * 获取当前最大挂号序号
     * @param ksdm
     * @param ysdm
     * @return
     */
    Map<String, Object> getGhxh(@Param("ksdm") String ksdm, @Param("ysdm") String ysdm);

    void addGhmx(@Param("ksdm") String ksdm, @Param("ysdm") String ysdm, @Param("ghxh") int ghxh, @Param("brbh") String brbh);
}
