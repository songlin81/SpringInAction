package com.example.demo.util.result;

public enum ExceptionMsg {
    SUCCESS("200", "OK"),
    FAILED("999999","Fail"),
    ParamError("000001", "args err"),
    LoginNameOrPassWordError("000100", "Username or password is incorrect"),
    EmailUsed("000101","email already registered"),
    UserNameUsed("000102","username used"),
    EmailNotRegister("000103","EmailNotRegister"),
    PassWordError("000105","PassWordError"),
    LoginNameNotExists("000107","LoginNameNotExists"),
    UserNameSame("000108","UserNameSame"),
    MobileUsed("000109","MobileUsed"),
    FileEmpty("000500","FileEmpty"),
    LimitPictureSize("000501","LimitPictureSize 2M"),
    LimitPictureType("000502","LimitPictureType'jpg'、'png'、'jpge'、'gif'、'bmp'");

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