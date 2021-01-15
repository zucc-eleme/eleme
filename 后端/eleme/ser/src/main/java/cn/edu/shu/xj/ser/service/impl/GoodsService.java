package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.mapper.GoodsMapper;
import cn.edu.shu.xj.ser.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public int isGoodsNameExist(String goodsName,long storeId){
        return goodsMapper.isGoodsNameExist(goodsName,storeId);
    }

    public List<Goods> listByClassInStore(long storeId, String className){
        return goodsMapper.listByClassInStore(storeId,className);
    }

    public List<String> classInStore(long storeId){
        return goodsMapper.classInStore(storeId);
    }
}
