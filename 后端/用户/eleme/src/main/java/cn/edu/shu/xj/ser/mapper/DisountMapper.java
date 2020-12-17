package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Discount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DisountMapper {
//     String discountId; //优惠券id
//     String userId; //用户id
//     String discountName; //优惠券名称
//     float discountMoney; //优惠价格
//     float startMoney; //使用优惠券的最低价格

    /**
     * @param discountid
     * @return
     */
    @Select("SELECT * FROM discount " +
            "WHERE discount_id =#{discountid} ")
    Discount findOneDiscount(@Param("discountid") String discountid);

    /**
     * @param discountid,userid,discountname,discountmoney,startmoney
     * @return
     */
    @Insert("INSERT INTO discount(discount_id,user_id,discount_name,discount_money,start_money) " +
            "VALUES(#{discountid},#{userid},#{discountname},#{discountmoney},#{startmoney})")
    Discount addOneUserDiscount(@Param("discountid") String discountid,
                                @Param("userid") String userid,
                                @Param("discountname") String discountname,
                                @Param("discountmoney") float discountmoney,
                                @Param("startmoney") float startmoney);
}
