package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("SELECT COUNT(*) FROM goods WHERE goods_name=#{goodsName} AND store_id=#{storeId}")
    int isGoodsNameExist(@Param("goodsName") String goodsName,@Param("storeId") long storeId);

    @Select("SELECT * FROM goods WHERE store_id=#{storeId} AND class_name=#{className}")
    List<Goods> listByClassInStore(@Param("storeId")long storeId,@Param("className")String className);

    @Select("SELECT DISTINCT class_name FROM goods WHERE store_id=#{storeId}")
    List<String> classInStore(@Param("storeId")long storeId);
}
