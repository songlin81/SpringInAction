package com.example.demo.util.result;

public class Response {

    private String rspCode="000000";

    private String rspMsg="OPT OK";

    public Response() {
    }

    public Response(ExceptionMsg msg){
        this.rspCode=msg.getCode();
        this.rspMsg=msg.getMsg();
    }

    public Response(String rspCode) {
        this.rspCode = rspCode;
        this.rspMsg = "";
    }

    public Response(String rspCode, String rspMsg) {
        this.rspCode = rspCode;
        this.rspMsg = rspMsg;
    }
    public String getRspCode() {
        return rspCode;
    }
    public void setRspCode(String rspCode) {
        this.rspCode = rspCode;
    }
    public String getRspMsg() {
        return rspMsg;
    }
    public void setRspMsg(String rspMsg) {
        this.rspMsg = rspMsg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "rspCode='" + rspCode + '\'' +
                ", rspMsg='" + rspMsg + '\'' +
                '}';
    }
}