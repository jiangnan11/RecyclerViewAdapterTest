package com.example.lihao.recyclerviewadaptertest.bean;

/**
 * Created by lihao on 2017/10/28.
 */

public class Student {
    public Student(int index, String name) {
        this.index = index;
        this.name = name;
    }

    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
