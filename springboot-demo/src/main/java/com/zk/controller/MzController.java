package com.zk.controller;

import com.zk.service.MzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 门诊操作controller
 *
 * @author zk
 * @date 2020-9-9
 */
@RestController
public class MzController {
    @Autowired
    private MzService mzService;

    @PostMapping("/gh")
    public Map<String, Object> gh(@RequestParam("ksdm") String ksdm, @RequestParam("ysdm") String ysdm, @RequestParam("brid") String brid) {
        Map<String, Object> ghMap = mzService.gh(ksdm, ysdm, brid);
        return ghMap;
    }
}
