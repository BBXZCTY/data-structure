package com.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: hfr
 * @Date: 2019-07-30 13:45
 * @Version 1.0
 */
public class Test5 {

    public static void main(String[] args) {
        String result = "{\"status\":\"1\",\"regeocode\":{\"addressComponent\":{\"city\":\"杭州市\",\"province\":\"浙江省\",\"adcode\":\"330104\",\"district\":\"江干区\",\"towncode\":\"330104008000\",\"streetNumber\":{\"number\":\"148\",\"location\":\"120.212594,30.2525706\",\"direction\":\"西南\",\"distance\":\"73.757\",\"street\":\"江锦路\"},\"country\":\"中国\",\"township\":\"四季青街道\",\"businessAreas\":[{\"location\":\"120.206996,30.257641\",\"name\":\"四季青\",\"id\":\"330104\"},{\"location\":\"120.213988,30.250397\",\"name\":\"钱江新城\",\"id\":\"330104\"},{\"location\":\"120.197881,30.25336\",\"name\":\"采荷\",\"id\":\"330104\"}],\"building\":{\"name\":[],\"type\":[]},\"neighborhood\":{\"name\":[],\"type\":[]},\"citycode\":\"0571\"},\"formatted_address\":\"浙江省杭州市江干区四季青街道优佳教育培训学校悦玺啦啦啦啦啦啦啦啦啦啦啦啦啦啦啦啊啊\"},\"info\":\"OK\",\"infocode\":\"10000\"}";
        System.out.println("gps convert result===>"+result);
        JSONObject json = JSONObject.parseObject(result);
        JSONObject adress = json.getJSONObject("regeocode").getJSONObject("addressComponent");
        String address = json.getJSONObject("regeocode").getString("formatted_address");
        System.out.println(adress.getString("province"));
        System.out.println("[]".equals(adress.getString("city")) ? adress.getString("province") : adress.getString("city"));
        System.out.println(adress.getString("citycode"));
        System.out.println(adress.getString("district"));
        System.out.println(adress.getString("adcode"));
        System.out.println(address);
        System.out.println(address.length());
        System.out.println(address.substring(0,40));
        System.out.println(address.substring(0,40).length());
        String str = null;
        System.out.println(str.toString());
        System.out.println(str.length());
    }

}