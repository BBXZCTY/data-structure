package com.imooc.playwithdatastructure;

/**
 * @Author: hfr
 * @Date: 2019-08-07 13:54
 * @Version 1.0
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
