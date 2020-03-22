package com.imooc.playwithdatastructure.set_and_map;

import com.imooc.playwithdatastructure.FileOperation;
import com.imooc.playwithdatastructure.Set;
import com.imooc.playwithdatastructure.binary_search_tree.BST;

import java.util.ArrayList;

/**
 * @Author: hfr
 * @Date: 2019-08-20 22:01
 * @Version 1.0
 */
public class BSTSet<E extends Comparable<E>>  implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
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
    }

    private static void operate(ArrayList<String> words) {
        System.out.println("Total words: " + words.size());

        BSTSet<String> set = new BSTSet<>();
        for (String word : words)
            set.add(word);
        System.out.println("Total different words: " + set.getSize());
    }
}