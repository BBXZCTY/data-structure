package com.leetcode;

/**
 *
 * 146. LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * The cache is initialized with a positive capacity.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache(2)
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 *
 *
 *
 */
public class Solution146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(3,2);
        System.out.println(cache.get(3));   // returns 2
        System.out.println(cache.get(2));   // returns 1
        cache.put(4,3);
        System.out.println(cache.get(2));   // returns 1
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


    }


    public void test01() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println("first: " + cache.getFirst());
        System.out.println(cache.get(4)); // returns 4
        System.out.println("first: " + cache.getFirst());
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 *
 */
class LRUCache {

    private int capacity;
    private int size = 0;
    private DoubleLinkNode dummyhead = new DoubleLinkNode(0, 0);
    private DoubleLinkNode dummytail = new DoubleLinkNode(0, 0);

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleLinkNode node = getNode(key);
        if (null == node) {
            return -1;
        }
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkNode node = getAndSetNode(key,value);
        if (null == node) {
            insert(new DoubleLinkNode(key, value));
        }
    }

    public int getFirst() {
        return getHeadNode().value;
    }


//  =============================================

    private DoubleLinkNode getAndSetNode(int key, int value) {
        DoubleLinkNode node = getNode(key);
        if (null != node) {
            node.value = value;
        }
        return node;
    }

    private DoubleLinkNode getNode(int key) {
        if (size == 0)
            return null;
        DoubleLinkNode prev = dummyhead.next;
        for (int i = 0; i < size; i++) {
            if (key == prev.key) {
                if (size != 1) {
                    evictEle(prev);
                    insert(prev);
                }
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }


    /**
     * insert to the head
     */
    private void insert(DoubleLinkNode node) {
        if (size == capacity) {
            evictEle(dummytail.prev);
        }

        if (size == 0) {
            node.next = dummytail;
            dummytail.prev = node;
        } else {
            DoubleLinkNode dummyheadNext = dummyhead.next;
            node.next = dummyheadNext;
            dummyheadNext.prev = node;
        }
        dummyhead.next = node;
        node.prev = dummyhead;

        size ++;
    }

    /**
     *
     * evict specified element
     */
    private void evictEle(DoubleLinkNode evictNode) {
        DoubleLinkNode evictNodePrev = evictNode.prev;
        DoubleLinkNode evictNodeNext = evictNode.next;

        evictNodePrev.next = evictNodeNext;
        evictNodeNext.prev = evictNodePrev;
        size --;
    }


    /**
     * evict the tail element
     */
    private void evictTail() {
        DoubleLinkNode evictNode = dummytail.prev;
        DoubleLinkNode tailNodePrev = evictNode.prev;

        tailNodePrev.next = dummytail;
        dummytail.prev = tailNodePrev;
        size --;
    }

    private DoubleLinkNode getHeadNode() {
        return dummyhead.next;
    }


    class DoubleLinkNode {
        private DoubleLinkNode next, prev;
        private int key, value;

        DoubleLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}