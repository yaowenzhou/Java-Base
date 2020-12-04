package com.xiaoyao.java;

public class Person {
    String name;
    int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("吃饭");
    }

    public void walk(int distance) {
        System.out.println("走路，走的距离是：" + distance + "公里。");
        show();
        eat();
    }

    private void show () {
        System.out.println("I'm a person.");
    }
}