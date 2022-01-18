package com.donghao.cloud.service;

import com.donghao.cloud.pojo.OpenFeignResponse;
import com.donghao.cloud.pojo.OpenFeignUser;
import org.springframework.stereotype.Component;

/**
 * @Author: DongHao
 * @Date: 2022/1/18 13:32
 * @Description:
 */
@Component
public class MyFallbackService implements OpenFeignUserService {
    @Override
    public OpenFeignResponse create(OpenFeignUser openFeignUser) {
        OpenFeignUser defaultUser = new OpenFeignUser(-1L, "defaultUser", "123456");
        return new OpenFeignResponse<>(defaultUser);
    }

    @Override
    public OpenFeignResponse<OpenFeignUser> getUser(Long id) {
        OpenFeignUser defaultUser = new OpenFeignUser(-1L, "defaultUser", "123456");
        return new OpenFeignResponse<>(defaultUser);
    }

    @Override
    public OpenFeignResponse<OpenFeignUser> getByUsername(String username) {
        OpenFeignUser defaultUser = new OpenFeignUser(-1L, "defaultUser", "123456");
        return new OpenFeignResponse<>(defaultUser);
    }

    @Override
    public OpenFeignResponse update(OpenFeignUser openFeignUser) {
        return new OpenFeignResponse("调用失败，服务被降级",500);
    }

    @Override
    public OpenFeignResponse delete(Long id) {
        return new OpenFeignResponse("调用失败，服务被降级",500);
    }
}
