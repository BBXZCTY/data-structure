package com.test;

/**
 * @Author: hfr
 * @Date: 2019-07-22 11:15
 * @Version 1.0
 */
public interface Merger<E> {

    E merge(E l, E r);
}