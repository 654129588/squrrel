package com.squirrel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.squirrel.entity.RequestEntity;
import com.squirrel.entity.Result;
import com.squirrel.service.ExpressService;
import com.squirrel.util.KdApiOrderDistinguish;
import com.squirrel.util.KdniaoSubscribeAPI;
import com.squirrel.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="smallProgram", method = RequestMethod.POST)
public class SmallProgramController {

    @Autowired
    private ExpressService expressService;

    @RequestMapping(value = "/kdniaoSubscribeAPI1002")
    public Result kdniaoSubscribeAPI1002(RequestEntity requestEntity){
        if(!requestEntity.checkSign()){
            return ResultUtils.error("-1","签名错误");
        }
        JSONObject result = new JSONObject();
        try {
            JSONObject jsonObject = JSON.parseObject(requestEntity.getJsonString());
            String ShipperCode = "";
            if(jsonObject.getString("shipperCode") != null && jsonObject.getString("shipperCode") != ""){
                ShipperCode = jsonObject.getString("shipperCode");
            }else {
                //查询快递公司编号
                KdApiOrderDistinguish api = new KdApiOrderDistinguish();
                JSONObject shippers = JSON.parseArray(JSON.parseObject(api.getOrderTracesByJson(jsonObject.getString("logisticCode"))).getString("Shippers")).getJSONObject(0);
                ShipperCode = shippers.getString("ShipperCode");
            }
            //查询快递物流信息
            KdniaoSubscribeAPI kdniaoSubscribeAPI = new KdniaoSubscribeAPI();
            result = JSON.parseObject(kdniaoSubscribeAPI.orderTracesSubByJson(jsonObject.getString("logisticCode"), ShipperCode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtils.success(result);
    }

    @RequestMapping(value = "/findExpressAll")
    public Result findExpressAll(RequestEntity requestEntity){
        if(!requestEntity.checkSign()){
            return ResultUtils.error("-1","签名错误");
        }
        return ResultUtils.success(expressService.findAll());
    }
}
