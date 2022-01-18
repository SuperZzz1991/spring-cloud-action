package com.donghao.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.donghao.cloud.handler.CustomBlockHandler;
import com.donghao.cloud.pojo.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 13:54
 * @Description: 限流功能
 */
@Log4j2
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {
    /**
     * 按资源名称限流，需要指定限流处理逻辑
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public Response byResource() {
        return new Response("按资源名称限流", 200);
    }

    /**
     * 按URL限流，有默认的限流处理逻辑
     */
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl",blockHandler = "handleException")
    public Response byUrl() {
        return new Response("按url限流", 200);
    }

    /**
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/customBlockHandler")
    @SentinelResource(value = "customBlockHandler", blockHandlerClass = CustomBlockHandler.class , blockHandler = "handleException")
    public Response blockHandler() {
        return new Response("限流成功", 200);
    }

    public static Response handleException(BlockException exception){
        return new Response(exception.getClass().getCanonicalName(),200);
    }
}
