package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Discount;
import cn.edu.shu.xj.ser.mapper.DisountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    //     String discount_id; //优惠券id
    //     String user_id; //用户id
    //     String discount_name; //优惠券名称
    //     float discount_money; //优惠价格
    //     float start_money; //使用优惠券的最低价格

    @Autowired
    DisountMapper disountMapper;

    public Discount findOneDiscount(String discountid){
        return disountMapper.findOneDiscount(discountid);
    }

    public Discount addOneUserDiscount(String discountid, String userid, String discountname, float discountmoney, float startmoney){
        return disountMapper.addOneUserDiscount(discountid,userid,discountname,discountmoney,startmoney);
    }
}
