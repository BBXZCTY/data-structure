package com.imooc.playwithdatastructure;

/**
 * @Author: hfr
 * @Date: 2019-08-07 15:53
 * @Version 1.0
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
