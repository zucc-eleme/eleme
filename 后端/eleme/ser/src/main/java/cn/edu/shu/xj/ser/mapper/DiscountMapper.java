package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Discount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DiscountMapper extends BaseMapper<Discount> {
    /**
     * @param discountId
     * @return
     */
    @Select("SELECT * FROM discount " +
            "WHERE discount_id =#{discountId} ")
    Discount findOneDiscount(@Param("discountId") long discountId);

    /**
     * @param discountName
     * @return
     */
    @Select("SELECT * FROM discount " +
            "WHERE discount_name =#{discountName} ")
    Discount findOneDiscountByName(@Param("discountName") String discountName);

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
