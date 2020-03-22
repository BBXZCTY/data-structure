package com.test;

/**
 * @Author: hfr
 * @Date: 2019-07-30 11:06
 * @Version 1.0
 */
public class Person {

    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String name = null;
        Person person = new Person();
        Bird bird = new Bird();
        bird.setName(name);
        person.setName(bird.getName());

        System.out.println(person);
        System.out.println(bird);

        Person p2 = person;
        System.out.println(p2);

        person.setName("zhangsan");
        System.out.println(p2);
    }
}