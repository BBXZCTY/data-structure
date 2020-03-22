package com.test;

/**
 * @Author: hfr
 * @Date: 2019-07-29 17:48
 * @Version 1.0
 */
public class GpsAdressVo {

    /**
     * 坐标点所在省名称
     */
    private String province;
    /**
     * 坐标点所在城市名称
     */
    private String city;
    /**
     * 城市编码
     */
    private String citycode;
    /**
     * 坐标点所在区
     */
    private String district;
    /**
     * 行政区编码
     */
    private String adcode;
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCitycode() {
        return citycode;
    }
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getAdcode() {
        return adcode;
    }
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }
    @Override
    public String toString() {
        return "GpsAdressVo [province=" + province + ", city=" + city
                + ", citycode=" + citycode + ", district=" + district
                + ", adcode=" + adcode + "]";
    }
}