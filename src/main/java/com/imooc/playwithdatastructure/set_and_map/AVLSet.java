package com.imooc.playwithdatastructure.set_and_map;

import com.imooc.playwithdatastructure.Set;
import com.imooc.playwithdatastructure.avltree.AVLTree;

/**
 * @Author: hfr
 * @Date: 2019-08-27 17:22
 * @Version 1.0
 */
public class AVLSet<E extends Comparable<E>> implements Set<E> {

    private AVLTree<E, Object> avl;

    public AVLSet(){
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
    public void add(E e){
        avl.add(e, null);
    }

    @Override
    public boolean contains(E e){
        return avl.contains(e);
    }

    @Override
    public void remove(E e){
        avl.remove(e);
    }
}
