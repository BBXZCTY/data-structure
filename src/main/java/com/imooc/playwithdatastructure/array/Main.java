package com.imooc.playwithdatastructure.array;

/**
 * @Author: hfr
 * @Date: 2019-08-07 10:05
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array<Integer>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeEle(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for(int i = 0 ; i < 4 ; i ++){
            arr.removeFirst();
            System.out.println(arr);
        }
    }

}