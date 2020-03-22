package com.imooc.playwithdatastructure.avltree;

import com.imooc.playwithdatastructure.FileOperation;
import com.imooc.playwithdatastructure.array.Array;

import java.util.*;

/**
 * @Author: hfr
 * @Date: 2019-08-23 09:56
 * @Version 1.0
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;
        public int width;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.width = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 判断该二叉树是否是一棵二分搜索树
    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        // 根据中序遍历的特性
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (null == node) return;
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (null == node) return true;
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    // 获得节点node的高度
    private int getHeight(Node node){
        if (null == node) return 0;
        return node.height;
    }

    // 获得节点node的宽度
    private int getWidth(Node node){
        if (null == node) return 0;
        return node.width;
    }

    // 获得节点node的平衡因子
    private int getBalanceFactor(Node node){
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        // rotate to the right
        x.right = y;
        y.left = T3;

        // update height
        return updateHeight(y, x);
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // rolate to the left
        x.left = y;
        y.right = T2;

        // update height

        return updateHeight(y, x);
    }

    // update height
    private Node updateHeight(Node y, Node x) {
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
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
        if (key.equals(node.key)) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.right = add(node.right, key, value);
        }
        return maintenanceBalance((Node) node);

    }

    // balance maintenance
    private Node maintenanceBalance(Node node) {
        // update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // calculate balance factor
        int balanceFactor = getBalanceFactor(node);

        // balance maintenance
        // LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotate(node);

        // RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotate(node);

        // LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){
        if (null == node) return null;
        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if (null == key) {
            throw new IllegalArgumentException(key + " don't exists !");
        }
        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if (null == node.left)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if (null == node.left) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key){
        Node node = getNode(root, key);
        if (null != node) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, K key) {
        if (null == node)
            return null;

        Node retNode;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
//            return node;
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
//            return node;
            retNode = node;
        } else {
            // 待删除节点左子树为空的情况
            if (null == node.left) {
                Node rightNode = node.right;
                node.right = null;
                size --;
//                return rightNode;
                retNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if (null == node.right) {
                Node leftNode = node.left;
                node.left = null;
                size --;
//                return leftNode;
                retNode = leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
//              successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
//              return successor;
                retNode = successor;
            }

        }

        if (null == retNode) return null;

        return maintenanceBalance(retNode);
    }

    public static void main(String[] args) {

        testRemove();

    }

    private static void testBSTString() {
        System.out.println();
        System.out.println(new AVLTree().generateBSTString());
        System.out.println("1" + "\t" + "2");

        AVLTree<Integer, Integer> tree = new AVLTree<>();
        tree.add(10,10);
        tree.add(9,9);
        tree.add(6,6);
        tree.add(12,12);
        tree.add(8,8);
        tree.add(5,5);
        tree.add(15,15);
        tree.add(21,21);
        tree.add(22,22);
        tree.add(23,23);
        tree.add(24,24);
        tree.add(25,25);
        tree.add(26,26);
        tree.add(27,27);
        tree.add(28,28);
        System.out.println(tree.isBalanced());
        System.out.println(tree.generateBSTString());
    }

    private static void testAdd() {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());
        }

    }

    private static void testRemove() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());

            long startTime = System.nanoTime();
            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced())
                    throw new RuntimeException();
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("remove time: " + time + " s");
        }

        System.out.println();
    }

    // 二分搜索树的层序遍历
    public void levelOrder(){
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();


        ArrayList<Integer> list;
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println("key = " + cur.key + ", height = " + cur.height);
            if (!hashMap.containsKey(cur.height)) {
                list = new ArrayList<>();
                hashMap.put(cur.height, list);
            } else {
                list = hashMap.get(cur.height);
            }
            list.add(Integer.parseInt(String.valueOf(cur.key)));

            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        System.out.println("hashMap = " + hashMap);


        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer + ":");

            List<Integer> list1 = hashMap.get(integer);
            for (int i = 0; i < list1.size(); i++) {
                System.out.println(list1.get(i));
                sb.append(AVLTree.cover(list1.get(i)));
            }
            System.out.println("----");

        }

    }

    private static String cover(int num) {
        if (num >=0 && num < 10) {
            return "0" + num;
        }
        return String.valueOf(num);
    }

    private static void appendBlank(StringBuilder sb, List<Integer> list, int height, int totalHeight) {

    }

    public String generateBSTString() {

        //    y                             x
        //  /  \                          /   \
        // T1   x      向左旋转 (y)       y     z
        //     / \   - - - - - - - ->   / \   / \
        //   T2  z                     T1 T2 T3 T4


        StringBuilder sb = new StringBuilder();
        sb.append("              21\n");
        sb.append("        /            \\\n");
        sb.append("      09              25\n");
        sb.append("   /      \\        /      \\\n");
        sb.append("  06      12      23      27\n");
        sb.append(" /  \\    /  \\    /  \\    /  \\ \n");
        sb.append("05  08  10  15  22  24  26  28\n");

        System.out.println(sb.toString());
        StringBuilder keys = new StringBuilder();
        // 根据中序遍历的特性
        levelOrder();
        return keys.toString();

    }
}