package com.company.Class;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int phone;

    public User(String userName, String password, String name, String surname, String email, int phone) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
    //private List<Team> teamList = new ArrayList<>();
}
