package com.androidavenger.firstproject.model;

import java.io.Serializable;




public class user implements Serializable {

    private String phone;
    private String email;
    private String description;

    public user(String phone, String email, String description ) {
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public user(String phone, String email ) {
        this.phone = phone;
        this.email = email;
        description = "";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
