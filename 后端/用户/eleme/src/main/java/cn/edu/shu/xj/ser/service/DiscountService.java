package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.discount;
import cn.edu.shu.xj.ser.mapper.DisountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    DisountMapper disountMapper;

    public discount findOneDiscount(String discountid){
        return disountMapper.findOneUserAddress(discountid);
    }
}
