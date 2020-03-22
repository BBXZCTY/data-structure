package com.imooc.playwithdatastructure;

/**
 * @Author: hfr
 * @Date: 2019-08-21 11:34
 * @Version 1.0
 */
public interface Map<K, V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();

}
