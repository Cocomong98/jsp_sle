package com.example.bean;

import java.util.Date;

public class MemberVO {
    private int sid;
    private String userid;
    private String gender;
    private int age;
    private String username;
    private String password;
    private String email;
    private String github;
    private String photo;
    private String detail;
    private Date regdate;

    public int getSid(){
        return sid;
    }
    public void setSid(int sid){
        this.sid=sid;
    }


    public void setPassword(String password){
        this.password=password;
    }
    public String getUserid(){
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public String getDetail() {
        return detail;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setRegdate(java.sql.Date regdate) {
        this.regdate = regdate;
    }

    public String getGender() { return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getAge() {
        return age;
    }
}
