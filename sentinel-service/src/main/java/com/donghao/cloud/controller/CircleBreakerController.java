package com.donghao.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.donghao.cloud.pojo.Response;
import com.donghao.cloud.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: DongHao
 * @Date: 2022/1/17 15:26
 * @Description: 熔断功能
 */
@Slf4j
@RestController
@RequestMapping("/breaker")
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String userServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handleFallback")
    public Response fallback(@PathVariable Long id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Response.class, id);
    }

    @RequestMapping("/fallbackException/{id}")
    @SentinelResource(value = "fallbackException",fallback = "handleFallback2", exceptionsToIgnore = {NullPointerException.class})
    public Response fallbackException(@PathVariable Long id) {
        if (id == 1) {
            throw new IndexOutOfBoundsException();
        } else if (id == 2) {
            throw new NullPointerException();
        }
        return restTemplate.getForObject(userServiceUrl + "/user/{1}", Response.class, id);
    }

    public static Response handleFallback(Long id) {
        log.error("自定义fallback：handleFallback");
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new Response<>(defaultUser,"服务降级返回",200);
    }

    public Response handleFallback2(@PathVariable Long id, Throwable e) {
        log.error("handleFallback2 id:{},throwable class:{}", id, e.getClass());
        User defaultUser = new User(-2L, "defaultUser2", "123456");
        return new Response<>(defaultUser,"服务降级返回",200);
    }
}
