package cn.edu.shu.xj.ser.entity;

public class user_address {
    private String user_id;     //记录用户id
    private String user_address; //记录地址
    private int main_address; //判断是否为主地址
    private String user_name;//用户姓名
    private int user_sex;   //用户性别，0是先生，1是女士，可以不设置
    private String address_detail; //地址详细信息，可以不设置
    private int address_type;   //地址类型，0是家，1是学校，2是公司，可以不设置

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public int getMain_address() {
        return main_address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(int user_sex) {
        this.user_sex = user_sex;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public int getAddress_type() {
        return address_type;
    }

    public void setAddress_type(int address_type) {
        this.address_type = address_type;
    }

    public void setMain_address(int main_address) {
        this.main_address = main_address;
    }
}
