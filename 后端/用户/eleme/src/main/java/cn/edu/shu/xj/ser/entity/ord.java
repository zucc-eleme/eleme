package cn.edu.shu.xj.ser.entity;

import java.util.Date;

public class Ord {
    private String ordId; //订单id
    private Long userId; //用户id
    private int storeId; //商家id
    private int riderId; //骑手id
    private float totalMoney; //总价
    private float totalDiscount; //满减
    private Date ordTime; //预计下单时间
    private float riderGet; //配送费

}
