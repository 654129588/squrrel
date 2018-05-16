package com.squirrel.util;

import com.squirrel.entity.Result;

public class ResultUtils {
    /**
     * 返回成功
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode("0");
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 返回失败
     * @param code
     * @param msg
     * @return
     */
    public static Result error(String code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}
