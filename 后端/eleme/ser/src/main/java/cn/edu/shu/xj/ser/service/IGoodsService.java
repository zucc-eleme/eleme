package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGoodsService extends IService<Goods> {
    int isGoodsNameExist(String goodsName,long storeId);

    List<Goods> listByClassInStore(long storeId, String className);

    List<String> classInStore(long storeId);
}
