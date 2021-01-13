package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.mapper.OrdMapper;
import cn.edu.shu.xj.ser.service.IOrdService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdService extends ServiceImpl<OrdMapper, Ord> implements IOrdService {
    @Autowired
    OrdMapper ordMapper;

    public List<Ord> ordsBeforeTime(int day, long storeId){
        return ordMapper.ordsBeforeTime(day,storeId);
    }

    public float profitInOneDay(int day, long storeId) {
        return ordMapper.profitInOneDay(day,storeId);
    }

    public int saveVolumeBeforeTime(int day, long storeId){
        return ordMapper.saveVolumeBeforeTime(day,storeId);
    }

    public float averageConsumption(long storeId,int isReturn){
        return ordMapper.averageConsumption(storeId,isReturn);
    }

    public Ord findOrd(long storeId,long userId){
        return ordMapper.findOrd(storeId,userId);
    }

    public Ord findOneOrder(String ordid){
        return ordMapper.findOneOrder(ordid);
    }

    public List<Ord> queryOrd(long storeId,long isReturn){
        return ordMapper.queryOrd(storeId,isReturn);
    }
}
