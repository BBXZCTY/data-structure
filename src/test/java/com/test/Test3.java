package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hfr
 * @Date: 2019-07-29 17:47
 * @Version 1.0
 */
public class Test3 {

    /**高德地图KEY*/
    private final static String GAODE_KEY = "81c3a0d92c4717c39be380f5eddd90b7";
    /**高德逆地理位置URL*/
    private final static String GAODE_API_URL_01 = "https://restapi.amap.com/v3/geocode/regeo";

    public static GpsAdressVo locationConvert(String longitude,String latitude){
//        try{
//            GpsAdressVo vo = new GpsAdressVo();
//            Map<String,String> param = new HashMap<String,String>();
//            param.put("key", GAODE_KEY);
//            param.put("location", longitude+","+latitude);
//            param.put("s", "rsv3");
//            String result =  HttpClientUtil.doGet(GAODE_API_URL_01, param);
//            //String result = HttpUtils.URLGet(GAODE_API_URL_01, param, "UTF-8");
//            System.out.println("gps convert result===>"+result);
//            JSONObject json = JSONObject.parseObject(result);
//            if("1".equals(json.getString("status"))){
//                JSONObject adress = json.getJSONObject("regeocode").getJSONObject("addressComponent");
//                vo.setProvince(adress.getString("province"));
//                vo.setCity("[]".equals(adress.getString("city")) ? adress.getString("province") : adress.getString("city"));
//                vo.setCitycode(adress.getString("citycode"));
//                vo.setDistrict(adress.getString("district"));
//                vo.setAdcode(adress.getString("adcode"));
//                return vo;
//            }
//        }catch(Exception e){
//            LOGGER.error(e.getMessage(),e);
//        }
        return null;
    }

    public static void main(String[] args) {
        locationConvert("116.481488","39.990464");
    }
}