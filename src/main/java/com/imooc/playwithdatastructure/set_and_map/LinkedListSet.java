package com.imooc.playwithdatastructure.set_and_map;

import com.imooc.playwithdatastructure.FileOperation;
import com.imooc.playwithdatastructure.LinkedList.LinkedList;
import com.imooc.playwithdatastructure.Set;

import java.util.ArrayList;

/**
 * @Author: hfr
 * @Date: 2019-08-21 11:12
 * @Version 1.0
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            operate(words1);
        }

        System.out.println();

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words2)){
            operate(words2);
        }
        System.out.println("\ncompleted");
    }

    private static void operate(ArrayList<String> words) {
        System.out.println("Total words: " + words.size());

        LinkedListSet<String> set = new LinkedListSet<>();
        for (String word : words)
            set.add(word);
        System.out.println("Total different words: " + set.getSize());
    }
}