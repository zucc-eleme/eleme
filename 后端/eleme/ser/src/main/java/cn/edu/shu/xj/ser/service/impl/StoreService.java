package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.mapper.StoreMapper;
import cn.edu.shu.xj.ser.service.IStoreService;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StoreService extends ServiceImpl<StoreMapper, Store> implements IStoreService {
    @Autowired
    StoreMapper storeMapper;

    public Store findOneStore(String phone){return storeMapper.findOneStore(phone);}

    public List<Store> allStores(){
        return storeMapper.allStores();
    }

    public List<Store> storesByGoods(String goodsName) {
        return storeMapper.storesByGoods(goodsName);
    }
}
