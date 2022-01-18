package com.donghao.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.donghao.cloud.pojo.Response;
import lombok.extern.log4j.Log4j2;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 14:06
 * @Description: 自定义限流处理逻辑。处理方法必须为static
 */
@Log4j2
public class CustomBlockHandler {
    public static Response handleException(BlockException exception){
        return new Response("自定义限流信息",200);
    }
}
