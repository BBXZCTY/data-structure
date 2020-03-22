package com.util;

import com.imooc.playwithdatastructure.array.Array;

import java.io.*;
import java.util.*;

/**
 * @Author: hfr
 * @Date: 2020-03-05 10:35
 * @Version 1.0
 */
public class FileUtil {

    private static int m = 8;

    static {
        System.out.println(m);
    }

    /**
     * 读入TXT文件
     */
    public static String readFile(String pathname) {
         // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        String line = "";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            line = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    /**
     * 写入TXT文件
     */
    public static void writeFile(String pathname, String str) {
        try {
            File writeName = new File(pathname); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {

                System.out.println();
                String[] split = str.split("],\\[");
                List<String> list = Arrays.asList(split);
                System.out.println(list);
                List<String> list1 = new ArrayList<>();
                for (String s : list) {
                    if (s.contains("[")) {
                        s = s.replace("[", "");
                    }
                    if (s.contains("]")) {
                        s = s.replace("]","");
                    }
                    list1.add(s);
                }
                System.out.println();
                System.out.println(list1);

                System.out.println();

                StringBuilder sb = new StringBuilder();

                for (String s : list1) {
                    System.out.println(s);
                    System.out.println(s.contains(","));
                    if (s.contains(",")) {
                        sb.append("cache.put(").append(s).append(");\n");
                    } else {
                        sb.append("System.out.println(cache.get(").append(s).append("));\n");
                    }
                    sb.append("System.out.println(cache.toString());\n");
                }


                out.write(sb.toString());
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        String readPathName = "params.txt";
        String str = readFile(readPathName);
        System.out.println(str);
        String writePathName = "output.txt";
        writeFile(writePathName, str);
    }

    public static void test() {
        System.out.println(666);
    }

}