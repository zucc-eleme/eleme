package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StoreMapper extends BaseMapper<Store> {

    @Select("select * from store where store_phone=#{phone}")
    Store findOneStore(@Param("phone") String phone);

    @Select("select * from store")
    List<Store> allStores();

    @Select("SELECT * FROM store\n" +
            "WHERE store_id in(\n" +
            "\tSELECT store_id FROM goods WHERE goods_name LIKE #{goodsName}\n" +
            ")")
    List<Store> storesByGoods(@Param("goodsName")String goodsName);

}