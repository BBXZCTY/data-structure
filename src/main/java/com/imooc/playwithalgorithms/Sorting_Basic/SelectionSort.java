package com.imooc.playwithalgorithms.Sorting_Basic;

/**
 * @Author: hfr
 * @Date: 2019-09-01 16:43
 * @Version 1.0
 *
 * 0、在[0,n]区间中，遍历所有的元素，选择最小的元素，然后和索引为0的元素互换
 * 1、在[1,n]区间中，遍历所有的元素，选择最小的元素，然后和索引为1的元素互换
 * ...
 * n-1、在[n-1,n]区间中...
 *
 *
 */
public class SelectionSort {

    // 我们的算法类不允许产生任何实例
    private SelectionSort(){}

    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for( int i = 0 ; i < n ; i ++ ){
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for( int j = i + 1 ; j < n ; j ++ )
                // 使用compareTo方法比较两个Comparable对象的大小
                if( arr[j].compareTo( arr[minIndex] ) < 0 )
                    minIndex = j;

            swap( arr , i , minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void test2() {
        // 测试Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(a);
        testSort(a);

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        testSort(b);

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        testSort(c);

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectionSort.sort(d);
        for( int i = 0 ; i < d.length ; i ++ )
            System.out.println(d[i]);
    }

    private static void testSort(Object[] a) {
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    private static void test3() {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SelectionSort.sort( arr );
        SortTestHelper.printArray(arr);
    }

    private static void test4() {
        // 测试排序算法辅助函数
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.imooc.playwithalgorithms.Sorting_Basic.SelectionSort", arr);
    }

    public static void main(String[] args) {
        test3();
        System.out.println("=======");
        test4();
    }


}