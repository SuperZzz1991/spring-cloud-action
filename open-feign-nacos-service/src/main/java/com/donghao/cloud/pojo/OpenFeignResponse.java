package com.donghao.cloud.pojo;

import lombok.Data;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 09:21
 * @Description:
 */
@Data
public class OpenFeignResponse<T> {
    private T data;
    private String message;
    private Integer code;

    public OpenFeignResponse() {
    }

    public OpenFeignResponse(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public OpenFeignResponse(String message, Integer code) {
        this(null, message, code);
    }

    public OpenFeignResponse(T data) {
        this(data, "操作成功", 200);
    }
}
