package com.donghao.cloud.pojo;

import lombok.Data;

/**
 * @Author: DongHao
 * @Date: 2022/1/14 09:21
 * @Description:
 */
@Data
public class Response<T> {
    private T data;
    private String message;
    private Integer code;

    public Response() {
    }

    public Response(T data, String message, Integer code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public Response(String message, Integer code) {
        this(null, message, code);
    }

    public Response(T data) {
        this(data, "操作成功", 200);
    }
}
