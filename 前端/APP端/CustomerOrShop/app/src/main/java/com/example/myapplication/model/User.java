package com.example.myapplication.model;

import com.google.gson.Gson;

public class User {

    /**
     * user_id : 账号
     * user_name : 昵称
     * user_phone : 电话
     * user_pwd : 密码
     * user_main_address : 地址
     * user_sex : 性别
     */

    private String user_id;
    private String user_name;
    private String user_phone;
    private String user_pwd;
    private String user_main_address;
    private int user_sex;

    public static User objectFromData(String str) {
        return new Gson().fromJson(str, User.class);
    }

    public String getUser_id() { return user_id; }

    public void setUser_id(String user_id) { this.user_id = user_id; }

    public String getUser_name() { return user_name;}

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_main_address() {
        return user_main_address;
    }

    public void setUser_main_address(String user_main_address) {
        this.user_main_address = user_main_address;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }
}
