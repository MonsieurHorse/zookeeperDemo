package com.common.zookeeper;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.*;
import org.junit.Test;

/**
 * Created by junbaoma on 2017/10/10.
 */
public class JsonTest {

    @org.junit.Test
    public void testStringToJson(){
        String string = "[{\"id\":\"7\",\"hot_search\":\"陕西破获古墓盗窃\",\"sort\":\"2\",\"status\":\"1\",\"created_time\":\"1509503033607\",\"updated_time\":\"1510286375447\"},{\"id\":\"9\",\"hot_search\":\"郑恺为王源送祝福\",\"sort\":\"1\",\"status\":\"1\",\"created_time\":\"1510193343025\",\"updated_time\":\"1510286375444\"},{\"id\":\"10\",\"hot_search\":\"欢迎特朗普访华\",\"sort\":\"7\",\"status\":\"1\",\"created_time\":\"1510193343031\",\"updated_time\":\"1510286375460\"},{\"id\":\"11\",\"hot_search\":\"运钞车劫案宣判\",\"sort\":\"3\",\"status\":\"1\",\"created_time\":\"1510193343036\",\"updated_time\":\"1510286375449\"},{\"id\":\"13\",\"hot_search\":\"中美签2535亿大单\",\"sort\":\"4\",\"status\":\"1\",\"created_time\":\"1510284696950\",\"updated_time\":\"1510286375452\"},{\"id\":\"14\",\"hot_search\":\"NBA骑士战火箭\",\"sort\":\"5\",\"status\":\"1\",\"created_time\":\"1510284696952\",\"updated_time\":\"1510286375455\"},{\"id\":\"15\",\"hot_search\":\"火箭再召回周琦\",\"sort\":\"6\",\"status\":\"1\",\"created_time\":\"1510284696954\",\"updated_time\":\"1510286375458\"}]";
        JSONObject jsonObject= JSONObject.parseObject(string);
//        JSONObject jsonObject = JSONObject.parseObject(message);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.get("errorCode"));
        System.out.println(jsonObject.get("errorMsg"));
    }

    @Test
    public void testMessageJson(){
        String guessId = "guessId";
        String userId = "userId";
        int source = 0;
        int count = 100;
        JSONObject reportJson = new JSONObject();
        reportJson.put("guessId", guessId);
        reportJson.put("userId", userId);
        reportJson.put("source", source);
        reportJson.put("count", count);

        // 给内容组上报用户参与竞猜行为数据
        String message = reportJson.toString();
        System.out.println(message);
    }

    @Test
    public void testNu(){
        System.out.println(StringUtils.isNumeric("-1"));
    }
}
