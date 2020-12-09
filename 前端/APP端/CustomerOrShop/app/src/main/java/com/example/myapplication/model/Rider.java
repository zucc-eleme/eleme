package com.example.myapplication.model;

import com.google.gson.Gson;

public class Rider {

    /**
     * rider_id : 骑手ID
     * rider_name : 骑手名
     * rider_passwd : 密码
     * rider_phone : 电话
     * rider_position : 位置
     */

    private String rider_id;
    private String rider_name;
    private String rider_passwd;
    private String rider_phone;
    private String rider_position;

    public static Rider objectFromData(String str) {

        return new Gson().fromJson(str, Rider.class);
    }

    public String getRider_id() {
        return rider_id;
    }

    public void setRider_id(String rider_id) {
        this.rider_id = rider_id;
    }

    public String getRider_name() {
        return rider_name;
    }

    public void setRider_name(String rider_name) {
        this.rider_name = rider_name;
    }

    public String getRider_passwd() {
        return rider_passwd;
    }

    public void setRider_passwd(String rider_passwd) {
        this.rider_passwd = rider_passwd;
    }

    public String getRider_phone() {
        return rider_phone;
    }

    public void setRider_phone(String rider_phone) {
        this.rider_phone = rider_phone;
    }

    public String getRider_position() {
        return rider_position;
    }

    public void setRider_position(String rider_position) {
        this.rider_position = rider_position;
    }
}
