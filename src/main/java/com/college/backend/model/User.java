package com.college.backend.model;

public sealed class User permits Volunteer {
    protected int userid;
    protected String name;
    protected String email;
    protected String role;
    protected String phone;
    public User(int userid, String name, String email, String role, String phone) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.role = role;
        this.phone = phone;
    }
}
