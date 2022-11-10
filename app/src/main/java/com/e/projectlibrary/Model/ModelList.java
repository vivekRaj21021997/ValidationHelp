package com.e.projectlibrary.Model;

public class ModelList {
    String name,address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ModelList(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
