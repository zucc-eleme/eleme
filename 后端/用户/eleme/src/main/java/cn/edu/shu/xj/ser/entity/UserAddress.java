package cn.edu.shu.xj.ser.entity;

public class UserAddress {
    private Long userId;     //记录用户id
    private String userAddress; //记录地址
    private int mainAddress; //判断是否为主地址
    private String userName;//用户姓名
    private int userSex;   //用户性别，0是先生，1是女士，可以不设置
    private String addressDetail; //地址详细信息，可以不设置
    private int addressType;   //地址类型，0是家，1是学校，2是公司，可以不设置
}
