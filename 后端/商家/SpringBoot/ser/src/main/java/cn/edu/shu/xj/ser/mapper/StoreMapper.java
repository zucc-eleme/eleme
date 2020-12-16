package cn.edu.shu.xj.ser.mapper;

import cn.edu.shu.xj.ser.entity.Store;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface StoreMapper extends BaseMapper<Store> {

    @Select("select * from store where store_phone=#{phone}")
    Store findOneStore(@Param("phone") String phone);
}