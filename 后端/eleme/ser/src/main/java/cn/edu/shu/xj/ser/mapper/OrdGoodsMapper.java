package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.OrdGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrdGoodsMapper extends BaseMapper<OrdGoods> {

    @Select("SELECT SUM(goods_num*goods_price) FROM ord_goods WHERE ord_id=#{ordId}")
    float totalMoney(@Param("ordId")long ordId);
}
