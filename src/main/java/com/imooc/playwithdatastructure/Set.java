package com.imooc.playwithdatastructure;

/**
 * @Author: hfr
 * @Date: 2019-08-20 22:02
 * @Version 1.0
 */
public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();

}
