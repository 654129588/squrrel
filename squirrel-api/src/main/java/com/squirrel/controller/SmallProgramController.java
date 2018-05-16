package com.squirrel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.squirrel.entity.RequestEntity;
import com.squirrel.entity.Result;
import com.squirrel.util.KdApiOrderDistinguish;
import com.squirrel.util.KdniaoSubscribeAPI;
import com.squirrel.util.ResultUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="smallProgram", method = RequestMethod.POST)
public class SmallProgramController {

    @RequestMapping(value = "/kdniaoSubscribeAPI1002")
    public Result kdniaoSubscribeAPI1002(RequestEntity requestEntity){
        if(!requestEntity.checkSign()){
            return ResultUtils.error("-1","签名错误");
        }
        JSONObject result = new JSONObject();
        try {
            JSONObject jsonObject = JSON.parseObject(requestEntity.getJsonString());
            //查询快递公司编号
            KdApiOrderDistinguish api = new KdApiOrderDistinguish();
            JSONObject shippers = JSON.parseObject(JSON.parseObject(api.getOrderTracesByJson(jsonObject.getString("shipperCode"))).getString("Shippers"));
            //测试
            //查询快递物流信息
            KdniaoSubscribeAPI kdniaoSubscribeAPI = new KdniaoSubscribeAPI();
            result = JSON.parseObject(kdniaoSubscribeAPI.orderTracesSubByJson(shippers.getString("ShipperCode"), jsonObject.getString("shipperCode")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.success(result);
    }
}
