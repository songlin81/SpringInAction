package com.example.demo.result;

public enum ExceptionMsg {

    SUCCESS("200", "operation success"),

    FAILED("999999","operation fail"),

    ParamError("000001", "arg error!"),

    FileEmpty("000400","uploaded is empty"),

    LimitPictureSize("000401","image should less than 2M"),

    LimitPictureType("000402","Image format required: 'jpg'、'png'、'jpge'、'gif'、'bmp'");

    private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}