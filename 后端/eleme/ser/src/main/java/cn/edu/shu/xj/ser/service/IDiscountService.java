package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Discount;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IDiscountService extends IService<Discount> {
    Discount findOneDiscount(long discountId);
    Discount findOneDiscountByName(String discountName);
}
