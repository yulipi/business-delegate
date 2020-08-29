package com.example.businessdelegate.entities;

import java.io.Serializable;

public class Employee implements Serializable {

    private long id;
    private String name;
    private String sex;
    private String address;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSex() {
        return sex;
    }

    public long getId() {
        return id;
    }
}

