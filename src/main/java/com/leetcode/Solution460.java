package com.leetcode;

/**
 *
 * 460. LFU Cache
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 *
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 *
 *
 * Example:
 * LFUCache cache = new LFUCache( 2 capacity  )
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class Solution460 {

    public static void main(String[] args) throws Exception {
        test06();
    }

    public static void test06() {
        LFUCache cache = new LFUCache(10);
        System.out.println(cache.get(10));
        System.out.println(cache.toString());
        cache.put(10,13);
        System.out.println(cache.toString());
        cache.put(3,17);
        System.out.println(cache.toString());
        cache.put(6,11);
        System.out.println(cache.toString());
        cache.put(10,5);
        System.out.println(cache.toString());
        cache.put(9,10);
        System.out.println(cache.toString());
        System.out.println(cache.get(13));
        System.out.println(cache.toString());
        cache.put(2,19);
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        cache.put(5,25);
        System.out.println(cache.toString());
        System.out.println(cache.get(8));
        System.out.println(cache.toString());
        cache.put(9,22);
        System.out.println(cache.toString());
        cache.put(5,5);
        System.out.println(cache.toString());
        cache.put(1,30);
        // now:     dummyhead-->[2,5,5]-->[2,9,22]-->[2,3,17]-->[2,2,19]-->[2,10,5]-->[1,6,11]-->[1,1,30]-->dummytail
        // expect:  dummyhead-->[2,5,5]-->[2,9,22]-->[2,3,17]-->[2,2,19]-->[2,10,5]-->[1,1,30]-->[1,6,11]-->dummytail
        System.out.println(cache.toString());
        System.out.println(cache.get(11));
        System.out.println(cache.toString());
        cache.put(9,12);
        System.out.println(cache.toString());
        System.out.println(cache.get(7));
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        System.out.println(cache.get(8));
        System.out.println(cache.toString());
        System.out.println(cache.get(9));
        System.out.println(cache.toString());
        cache.put(4,30);
        System.out.println(cache.toString());
        cache.put(9,3);
        System.out.println(cache.toString());
        System.out.println(cache.get(9));
        System.out.println(cache.toString());
        System.out.println(cache.get(10));
        System.out.println(cache.toString());
        System.out.println(cache.get(10));
        System.out.println(cache.toString());
        cache.put(6,14);
        System.out.println(cache.toString());
        cache.put(3,1);
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        cache.put(10,11);
        System.out.println(cache.toString());
        System.out.println(cache.get(8));
        System.out.println(cache.toString());
        cache.put(2,14);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        System.out.println(cache.get(4));
        System.out.println(cache.toString());
        cache.put(11,4);
        System.out.println(cache.toString());
        cache.put(12,24);
        System.out.println(cache.toString());
        cache.put(5,18);
        System.out.println(cache.toString());
        System.out.println(cache.get(13));
        System.out.println(cache.toString());
        cache.put(7,23);
        System.out.println(cache.toString());
        System.out.println(cache.get(8));
        System.out.println(cache.toString());
        System.out.println(cache.get(12));  // expect returns 24 buy returns -1
        System.out.println(cache.toString());
        cache.put(3,27);
        System.out.println(cache.toString());
        cache.put(2,12);
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        cache.put(2,9);
        System.out.println(cache.toString());
        cache.put(13,4);
        System.out.println(cache.toString());
        cache.put(8,18);
        System.out.println(cache.toString());
        cache.put(1,7);
        System.out.println(cache.toString());
        System.out.println(cache.get(6));
        System.out.println(cache.toString());
        cache.put(9,29);
        System.out.println(cache.toString());
        cache.put(8,21);
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        cache.put(6,30);
        System.out.println(cache.toString());
        cache.put(1,12);
        System.out.println(cache.toString());
        System.out.println(cache.get(10));
        System.out.println(cache.toString());
        cache.put(4,15);
        System.out.println(cache.toString());
        cache.put(7,22);
        System.out.println(cache.toString());
        cache.put(11,26);
        System.out.println(cache.toString());
        cache.put(8,17);
        System.out.println(cache.toString());
        cache.put(9,29);
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        cache.put(3,4);
        System.out.println(cache.toString());
        cache.put(11,30);
        System.out.println(cache.toString());
        System.out.println(cache.get(12));
        System.out.println(cache.toString());
        cache.put(4,29);
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        System.out.println(cache.get(9));
        System.out.println(cache.toString());
        System.out.println(cache.get(6));
        System.out.println(cache.toString());
        cache.put(3,4);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.get(10));
        System.out.println(cache.toString());
        cache.put(3,29);
        System.out.println(cache.toString());
        cache.put(10,28);
        System.out.println(cache.toString());
        cache.put(1,20);
        System.out.println(cache.toString());
        cache.put(11,13);
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        cache.put(3,12);
        System.out.println(cache.toString());
        cache.put(3,8);
        System.out.println(cache.toString());
        cache.put(10,9);
        System.out.println(cache.toString());
        cache.put(3,26);
        System.out.println(cache.toString());
        System.out.println(cache.get(8));
        System.out.println(cache.toString());
        System.out.println(cache.get(7));
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        cache.put(13,17);
        System.out.println(cache.toString());
        cache.put(2,27);
        System.out.println(cache.toString());
        cache.put(11,15);
        System.out.println(cache.toString());
        System.out.println(cache.get(12));
        System.out.println(cache.toString());
        cache.put(9,19);
        System.out.println(cache.toString());
        cache.put(2,15);
        System.out.println(cache.toString());
        cache.put(3,16);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        cache.put(12,17);
        System.out.println(cache.toString());
        cache.put(9,1);
        System.out.println(cache.toString());
        cache.put(6,19);
        System.out.println(cache.toString());
        System.out.println(cache.get(4));
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        System.out.println(cache.get(5));
        System.out.println(cache.toString());
        cache.put(8,1);
        System.out.println(cache.toString());
        cache.put(11,7);
        System.out.println(cache.toString());
        cache.put(5,2);
        System.out.println(cache.toString());
        cache.put(9,28);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        cache.put(2,2);
        System.out.println(cache.toString());
        cache.put(7,4);
        System.out.println(cache.toString());
        cache.put(4,22);
        System.out.println(cache.toString());
        cache.put(7,24);
        System.out.println(cache.toString());
        cache.put(9,26);
        System.out.println(cache.toString());
        cache.put(13,28);
        System.out.println(cache.toString());
        cache.put(11,26);
        System.out.println(cache.toString());


    }

    public static void test05() throws Exception {
        LFUCache cache = new LFUCache(0);
        cache.put(0,0);
        System.out.println(cache.get(0));
    }


    public static void test04() throws Exception {
        LFUCache cache = new LFUCache(3);
        cache.put(2,2);
        cache.put(1,1);
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        cache.put(3,3);
        System.out.println(cache.toString());
        cache.put(4,4);
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.get(4));
        System.out.println(cache.toString());
    }

    public static void test03() throws Exception {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        cache.put(3,3);
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        cache.put(4,4);
        System.out.println(cache.toString());
        System.out.println(cache.get(1));
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        System.out.println(cache.get(4));
        System.out.println(cache.toString());

    }


    public static void test02() throws Exception {
        LFUCache cache = new LFUCache(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        System.out.println(cache.toString());
        cache.put(2,22);
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.get(3));
        System.out.println(cache.toString());
        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        System.out.println(cache.get(2));
        System.out.println(cache.toString());

        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        cache.put(6,6);
        System.out.println(cache.toString());
    }

    public static void test01() throws Exception {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));   // returns 1
        cache.put(3,3);                     // evicts key 2
        System.out.println(cache.get(2));   // returns -1 (not found)
        System.out.println(cache.get(3));   // returns 3
        cache.put(4,4);                     // evicts key 1
        System.out.println(cache.get(1));   // returns -1 (not found)
        System.out.println(cache.get(3));   // returns 3
        System.out.println(cache.get(4));   // returns 4
    }

}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 * 次数最少的排在尾部，次数最多的排在头部，次数相同，则最近使用的排在头部
 *
 */
class LFUCache {

    private int capacity;
    private int size = 0;
    private DoubleLinkNode dummyhead = new DoubleLinkNode(0, 0, 0);
    private DoubleLinkNode dummytail = new DoubleLinkNode(0, 0, 0);
    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleLinkNode node = getNode(key);
        if (null == node)
            return -1;
        return node.value;
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        DoubleLinkNode node = getAndSetNode(key, value);
        if (null == node) {
            if (size == capacity) {
                evictEle(dummytail.prev);
            }
            DoubleLinkNode specifiedNode = getSpecifiedNode(1);
//            System.out.println("put specifiedNode = " + specifiedNode);
            insertNodePrev(new DoubleLinkNode(key, value, 1), specifiedNode);
        }
    }

    public DoubleLinkNode getLinkNode(int key) {
        return getNode(key);
    }





//   ===========================================


    private DoubleLinkNode getAndSetNode(int key, int value) {
        DoubleLinkNode node = getNode(key);
        if (null != node) {
            node.value = value;
        }
        return node;
    }

    /**
     *
     *
     * @param key
     * @return
     */
    private DoubleLinkNode getNode(int key) {
        if (size == 0)
            return null;
        DoubleLinkNode prev = dummyhead.next;
        for (int i = 0; i < size; i++) {
            if (key == prev.key) {
                prev.times ++;
                if (size != 1) {
//                    System.out.println("insertNodeTimes = " + prev.times);
                    DoubleLinkNode specifiedNode = getSpecifiedNode(prev.times);
//                    System.out.println("specifiedNode = " + specifiedNode);
                    if (null != specifiedNode && key != specifiedNode.key) {
                        evictEle(prev);
                        insertNodePrev(prev, specifiedNode);
                    }
                }
                return prev;
            }
            prev = prev.next;
        }
        return null;
    }

    /**
     *
     * 关键方法
     *
     * get specified node that can be inserted to the next
     *
     * case0 (size == 1)
     * dummyhead-->insertNode(1)-->specifiedNode(1)-->dummytail
     * dummyhead-->specifiedNode(2)-->insertNode(1)-->dummytail
     *
     * case1:
     *
     * dummyhead-->insertNode(1)-->specifiedNode(1)-->node(1)-->dummytail
     * dummyhead-->insertNode(2)-->specifiedNode(2)-->node(2)-->dummytail
     *
     * case2:
     * dummyhead-->node(2)-->node(2)-->insertNode(1)-->dummytail
     * dummyhead-->node(2)-->node(2)-->insertNode(1)-->specifiedNode(1)-->dummytail
     * dummyhead-->node(6)-->node(5)-->node(5)-->insertNode(3)-->specifiedNode(2)-->node(2)-->dummytail
     * dummyhead-->node(6)-->node(5)-->node(5)-->insertNode(2)-->specifiedNode(2)-->node(2)-->dummytail
     *
     * case3: insert [1,1,30]
     * dummyhead-->[2,5,5]-->[2,9,22]-->[2,3,17]-->[2,2,19]-->[2,10,5]-->[1,6,11]-->dummytail
     * dummyhead-->[2,5,5]-->[2,9,22]-->[2,3,17]-->[2,2,19]-->[2,10,5]-->[1,1,30]-->[1,6,11]-->dummytail
     *
     *
     *
     * @param insertNodeTimes the use times of the insert node
     * @return
     */
    private DoubleLinkNode getSpecifiedNode(int insertNodeTimes) {
        // 从尾部开始找起，因为次数最少的排在尾部，次数最多的排在头部，次数相同，则最近使用的排在头部
        // 插入的元素大部分是新插入的

        if (size == 1) {
            if (dummytail.prev.times == 1) {
                return dummytail.prev;
            } else {    // dummytail.prev.times > 1
                return dummytail;
            }
        }

        DoubleLinkNode next = dummytail.prev;
        for (int i = 0; i < size; i++) {

            if (next.prev == dummyhead) {
                if (insertNodeTimes >= next.times) {
                    return next;
                }
            } else if (next.next == dummytail) {
                if (insertNodeTimes < next.times) {
                    return dummytail;
                } else {
                    if (insertNodeTimes < next.prev.times) {
                        return next;
                    }
                }
            } else {
                if (insertNodeTimes >= next.times && insertNodeTimes < next.prev.times) {
                    return next;
                }
            }
            next = next.prev;
        }
        return dummytail;
    }


    /**
     * insert to the specified node prev
     * 次数最少的排在尾部，次数最多的排在头部，次数相同，则最近使用的排在头部
     *
     * if size != 0
     * dummyhead-->node1-->specifiedPrev-->specifiedNode-->specifiedNext-->node2-->dummytail
     * after insert :
     * dummyhead-->node1-->specifiedPrev-->insertNode-->specifiedNode-->specifiedNext-->node2-->dummytail
     *
     *
     * if size == 0
     * dummyhead-->insertNode-->dummytail
     *
     * @param insertNode
     */
    private void insertNodePrev(DoubleLinkNode insertNode, DoubleLinkNode specifiedNode) {

        if (size == 0) {
            insertNode.next = dummytail;
            dummytail.prev = insertNode;

            insertNode.prev = dummyhead;
            dummyhead.next = insertNode;
        } else {
            DoubleLinkNode specifiedPrev = specifiedNode.prev;

            insertNode.next = specifiedNode;
            specifiedNode.prev = insertNode;

            specifiedPrev.next = insertNode;
            insertNode.prev = specifiedPrev;
        }

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



    class DoubleLinkNode {
        private DoubleLinkNode next, prev;
        private int times;
        private int key, value;

        DoubleLinkNode(int key, int value, int times) {
            this.times = times;
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "DoubleLinkNode{" +
                    "times=" + times +
                    ", key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("dummyhead-->");
        DoubleLinkNode next = dummyhead.next;
        for (int i = 0; i < size; i++) {
            sb.append("[");
            sb.append(next.times);
            sb.append(",");
            sb.append(next.key);
            sb.append(",");
            sb.append(next.value);
            sb.append("]-->");
            next = next.next;
        }
        sb.append("dummytail");
        return sb.toString();
//        return "";
    }
}

