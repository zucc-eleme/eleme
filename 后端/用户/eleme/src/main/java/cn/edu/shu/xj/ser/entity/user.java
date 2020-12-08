package cn.edu.shu.xj.ser.entity;

public class user {
    private String user_id;  //用户id
    private String user_name;//用户名
    private String user_pwd;//用户密码
    private String user_main_address;//用户主地址
    private String user_phone;//用户电话
    private int user_sex;   //性别，0是先生，1是女士

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

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
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
