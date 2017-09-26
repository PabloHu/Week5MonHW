package com.example.admin.week5monhw;

/**
 * Created by Admin on 9/25/2017.
 */

public class ContactObj {
    String name;
    String phone;

    public ContactObj(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
