package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Discount;
import cn.edu.shu.xj.ser.mapper.DiscountMapper;
import cn.edu.shu.xj.ser.service.IDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends ServiceImpl<DiscountMapper,Discount> implements IDiscountService {
    //     String discount_id; //优惠券id
    //     String user_id; //用户id
    //     String discount_name; //优惠券名称
    //     float discount_money; //优惠价格
    //     float start_money; //使用优惠券的最低价格

    @Autowired
    DiscountMapper discountMapper;

    public Discount findOneDiscount(String discountId){
        return discountMapper.findOneDiscount(discountId);
    }

    public Discount findOneDiscountByName(String discountName){
        return discountMapper.findOneDiscountByName(discountName);
    }

}
