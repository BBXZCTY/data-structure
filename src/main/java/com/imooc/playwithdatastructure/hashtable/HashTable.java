package com.imooc.playwithdatastructure.hashtable;

import java.util.TreeMap;

/**
 * @Author: hfr
 * @Date: 2019-08-29 16:14
 * @Version 1.0
 */
public class HashTable<K, V> {

    private TreeMap<K, V>[] hashtable;
    private int size;
    private int M;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(97);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) & M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key, V value){
        int hash = hash(key);
        TreeMap<K, V> map = hashtable[hash];
        map.put(key, value);
        if (map.containsKey(key)) {
            size ++;
        }
    }

    public V remove(K key){
        int hash = hash(key);
        TreeMap<K, V> map = hashtable[hash];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.get(key);
            map.remove(key);
            size --;
        }
        return ret;
    }

    public void set(K key, V value) {
        int hash = hash(key);
        TreeMap<K, V> map = hashtable[hash];
        if(!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");

        map.put(key, value);
    }

    public boolean contains(K key){
        return hashtable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashtable[hash(key)].get(key);
    }

}