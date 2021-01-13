package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Discount;
import cn.edu.shu.xj.ser.mapper.DiscountMapper;
import cn.edu.shu.xj.ser.service.IDiscountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService extends ServiceImpl<DiscountMapper, Discount> implements IDiscountService {
    @Autowired
    DiscountMapper discountMapper;

    public Discount findOneDiscount(long discountId){
        return discountMapper.findOneDiscount(discountId);
    }

    public Discount findOneDiscountByName(String discountName){
        return discountMapper.findOneDiscountByName(discountName);
    }


}
