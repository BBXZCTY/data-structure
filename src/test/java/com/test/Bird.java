package com.test;

import java.math.BigDecimal;

/**
 * @Author: hfr
 * @Date: 2019-07-30 11:13
 * @Version 1.0
 */
public class Bird {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bird(String name) {
        this.name = name;
    }

    public Bird() {
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String str = "1.045";
        BigDecimal bigDecimal = new BigDecimal(str);

        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));

        System.out.println('c' - 'a');
    }
}