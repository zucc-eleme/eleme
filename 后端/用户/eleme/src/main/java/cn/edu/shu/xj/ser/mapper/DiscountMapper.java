package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Discount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DiscountMapper extends BaseMapper<Discount> {
//     String discountId; //优惠券id
//     String userId; //用户id
//     String discountName; //优惠券名称
//     float discountMoney; //优惠价格
//     float startMoney; //使用优惠券的最低价格

    /**
     * @param discountId
     * @return
     */
    @Select("SELECT * FROM discount " +
            "WHERE discount_id =#{discountId} ")
    Discount findOneDiscount(@Param("discountId") String discountId);

    /**
     * @param discountName
     * @return
     */
    @Select("SELECT * FROM discount " +
            "WHERE discount_name =#{discountName} ")
    Discount findOneDiscountByName(@Param("discountName") String discountName);
}
