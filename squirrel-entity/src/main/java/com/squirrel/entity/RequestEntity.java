package com.squirrel.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestEntity {

    private final Logger log = LoggerFactory.getLogger(RequestEntity.class);

    private final String token = "6b0457b72fda36a2a89ee98cc85cbb30";

    private String sign;         //签名结果
    private String timestamp;   //时间戳
    private String jsonString;  //请求参数json字符串

    public RequestEntity(String sign, String timestamp, String jsonString) {
        super();
        this.sign = sign;
        this.timestamp = timestamp;
        this.jsonString = jsonString;
    }

    public boolean checkSign(){
        boolean flag = false;
        try {
            String param =this.token + this.timestamp;
            LinkedHashMap<String, String> jsonMap = JSON.parseObject(this.jsonString, new TypeReference<LinkedHashMap<String, String>>() {
            });
            for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
                log.info("key:{},value:{}",entry.getKey(),entry.getValue());
                param +=entry.getValue();
            }
            String md5DigestAsHex = DigestUtils.md5DigestAsHex(param.getBytes());
            System.out.println(md5DigestAsHex);
            if(md5DigestAsHex.equals(this.sign)){
                flag = true;
            }
        }catch (Exception e){
            log.error("检查参数错误:{}",e.getMessage());
        }
        return flag;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public static void main(String[] args) {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(new String("smallProgram").getBytes());
        System.out.println(md5DigestAsHex);
    }

}
