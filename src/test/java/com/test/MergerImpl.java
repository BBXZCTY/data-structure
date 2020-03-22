package com.test;

/**
 * @Author: hfr
 * @Date: 2019-07-22 11:17
 * @Version 1.0
 */
public class MergerImpl<E> {

    private E sum;

    public MergerImpl(E l, E r, Merger<E> merger) {
        this.sum = merger.merge(l,r);
    }

    public E getSum() {
        return sum;
    }

}