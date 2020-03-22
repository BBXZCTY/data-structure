package com.imooc.playwithdatastructure.RBTree;

/**
 * @Author: hfr
 * @Date: 2019-08-27 18:17
 * @Version 1.0
 */
public class _23Tree<K extends Comparable<K>, V>  {

    public static final int TWO = 2;
    public static final int THREE = 3;

    private class Node {
        public K key1;
        public K key2;
        public V value1;
        public V value2;
        public Node left, right, middle;
        public int height;
        public int nodeType;

        public Node(K key, V value) {
            this.key1 = key;
            this.value1 = value;
            this.key2 = null;
            this.value2 = null;
            this.left = null;
            this.right = null;
            this.middle = null;
            this.height = 1;
            this.nodeType = TWO;
        }
    }

    private Node root;
    private int size;

    public _23Tree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 获得节点node的高度
    private int getHeight(Node node){
        if (null == node) return 0;
        return node.height;
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value){
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {
        if (null == node) {
            size ++;
            return new Node(key, value);
        }

        if (key.equals(node.key1)) {
            node.value1 = value;
        } else if (key.equals(node.key2)) {
            node.value2 = value;
        }
        return null;
    }
}