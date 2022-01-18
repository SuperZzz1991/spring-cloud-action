package com.donghao.cloud.service;

import com.donghao.cloud.pojo.OpenFeignResponse;
import com.donghao.cloud.pojo.OpenFeignUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 09:23
 * @Description:
 */
@FeignClient(value = "nacos-user-service", fallback = MyFallbackService.class)
public interface OpenFeignUserService {
    @PostMapping("/user/create")
    OpenFeignResponse create(@RequestBody OpenFeignUser openFeignUser);

    @GetMapping("/user/{id}")
    OpenFeignResponse<OpenFeignUser> getUser(@PathVariable(value = "id") Long id);

    @GetMapping("/user/getByUsername")
    OpenFeignResponse<OpenFeignUser> getByUsername(@RequestParam(value = "username") String username);

    @PostMapping("/user/update")
    OpenFeignResponse update(@RequestBody OpenFeignUser openFeignUser);

    @PostMapping("/user/delete/{id}")
    OpenFeignResponse delete(@PathVariable(value = "id") Long id);
}
