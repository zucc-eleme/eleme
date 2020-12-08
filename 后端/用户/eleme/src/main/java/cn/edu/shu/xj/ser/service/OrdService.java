package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.ord;
import cn.edu.shu.xj.ser.mapper.OrdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdService {
    @Autowired
    OrdMapper ordMapper;

    public ord findOneOrder(String ordid){
        return ordMapper.findOneOrder(ordid);
    }
}
