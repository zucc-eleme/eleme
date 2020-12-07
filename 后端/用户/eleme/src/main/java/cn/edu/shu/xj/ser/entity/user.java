package cn.edu.shu.xj.ser.entity;

public class user {
    private String user_id;
    private String user_name;
    private String user_pwd;
    private String user_main_address;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

//    @Override
//    public String toString() {
//        return "user{" +
//                "user_id='" + user_id + '\'' +
//                ", user_name='" + user_name + '\'' +
//                ", user_pwd='" + user_pwd + '\'' +
//                ", user_main_address='" + user_main_address + '\'' +
//                '}';
//    }
}
