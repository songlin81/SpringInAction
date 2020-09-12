package com.example.demo.util.result;

public class ResultUtil {
    public static Result success(Integer code,String msg,Object object){
        Result result=new Result();
        result.setCode(200);
        result.setMsg("OK");
        result.setData(object);
        return result;
    }

    public static Result success(){
        return success(200,"Opt ok",null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}