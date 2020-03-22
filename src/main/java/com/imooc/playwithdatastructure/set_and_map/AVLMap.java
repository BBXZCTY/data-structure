package com.imooc.playwithdatastructure.set_and_map;

import com.imooc.playwithdatastructure.Map;
import com.imooc.playwithdatastructure.avltree.AVLTree;

/**
 * @Author: hfr
 * @Date: 2019-08-27 17:19
 * @Version 1.0
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap(){
        avl = new AVLTree<>();
    }

    @Override
    public int getSize(){
        return avl.getSize();
    }

    @Override
    public boolean isEmpty(){
        return avl.isEmpty();
    }

    @Override
    public void add(K key, V value){
        avl.add(key, value);
    }

    @Override
    public boolean contains(K key){
        return avl.contains(key);
    }

    @Override
    public V get(K key){
        return avl.get(key);
    }

    @Override
    public void set(K key, V newValue){
        avl.set(key, newValue);
    }

    @Override
    public V remove(K key){
        return avl.remove(key);
    }
}
