package com.imooc.playwithdatastructure.recursion;

/**
 * @Author: hfr
 * @Date: 2019-08-10 18:44
 * @Version 1.0
 */
public final class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String test1(String s) {
        String str = s;
        str = "hello";
        return s;
    }

    public Student test2(Student student) {
        Student student2 = student;
        student2.setName("test");
        return student;
    }

    public Student test3(Student student) {
        student.setName("hahha");
        return student;
    }

    public void test4(Student student) {
        student = new Student();
        student.setName("9099");
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 23);
        Student student2 = new Student("lisi", 24);

        Student student1a = student1;
        student1a.setName("zhangsan666");
        System.out.println(student1);

        System.out.println("==========");

        System.out.println(student2.test1("abc"));
        System.out.println(student2.test2(student2));
        System.out.println(student2.test3(student2));
        student2.test4(student2);
        System.out.println(student2);
    }


}