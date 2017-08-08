package com.tcsl.viewmodel.bean;

/**
 * 描述:
 * <p/>作者：wjx
 * <p/>创建时间: 2017/8/7 9:16
 */
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
