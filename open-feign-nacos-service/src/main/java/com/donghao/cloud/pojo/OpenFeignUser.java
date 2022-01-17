package com.donghao.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 09:20
 * @Description:
 */
@Data
@AllArgsConstructor
public class OpenFeignUser {
    private Long id;
    private String username;
    private String password;

    public OpenFeignUser(){

    }
}
