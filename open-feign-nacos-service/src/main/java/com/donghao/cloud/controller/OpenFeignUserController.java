package com.donghao.cloud.controller;

import com.donghao.cloud.pojo.OpenFeignResponse;
import com.donghao.cloud.pojo.OpenFeignUser;
import com.donghao.cloud.service.OpenFeignUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 09:19
 * @Description:
 */
@Log4j2
@RestController
@RequestMapping("/open-feign/user")
public class OpenFeignUserController {
    @Autowired
    private OpenFeignUserService openFeignUserService;

    @GetMapping("/{id}")
    public OpenFeignResponse getUser(@PathVariable(value = "id") Long id) {
        return openFeignUserService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public OpenFeignResponse getByUsername(@RequestParam(value = "username") String username) {
        return openFeignUserService.getByUsername(username);
    }

    @PostMapping("/create")
    public OpenFeignResponse create(@RequestBody OpenFeignUser openFeignUser) {
        return openFeignUserService.create(openFeignUser);
    }

    @PostMapping("/update")
    public OpenFeignResponse update(@RequestBody OpenFeignUser openFeignUser) {
        return openFeignUserService.update(openFeignUser);
    }

    @PostMapping("/delete/{id}")
    public OpenFeignResponse delete(@PathVariable(value = "id") Long id) {
        return openFeignUserService.delete(id);
    }
}
