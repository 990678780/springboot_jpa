package com.example.springboot_jpa.utils;

import org.springframework.context.annotation.Bean;

/**
 * 封装一个返回信息类
 */
public class ResMessage {
    private int code = 1;
    private String message = "success";

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
