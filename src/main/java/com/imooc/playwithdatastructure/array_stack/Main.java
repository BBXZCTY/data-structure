package com.imooc.playwithdatastructure.array_stack;

/**
 * @Author: hfr
 * @Date: 2019-08-07 13:52
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        System.out.println("--------------");

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.peek());
    }

}