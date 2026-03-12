package com.example.SpringDay4;

public class student {
    private int id;
    private String name;
    private int age;

    public student(int id,String Name,int age){
        this.id=id;
        this.name=Name;
        this.age=age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
