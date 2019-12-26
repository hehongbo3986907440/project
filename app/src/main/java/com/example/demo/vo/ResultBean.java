package com.example.demo.vo;

/**
 * com.example.demo.vo
 */
public class ResultBean {
    private String message;
    private int code;
    private Object data;

    public ResultBean(Object data) {
        this.data = data;
    }

    public ResultBean(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
