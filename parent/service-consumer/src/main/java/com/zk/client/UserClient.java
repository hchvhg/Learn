package com.zk.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-provider",fallback = UserClientFallBack.class)
public interface UserClient {
    @GetMapping("getUserById")
    public String getUserById(@RequestParam("id") String id);
}
