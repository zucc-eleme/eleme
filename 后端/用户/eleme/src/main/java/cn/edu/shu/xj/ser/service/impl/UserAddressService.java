package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.UserAddress;
import cn.edu.shu.xj.ser.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    @Autowired
    UserAddressMapper userAddressMapper;

    public UserAddress findOneUserAddress(String userid){
        return userAddressMapper.findOneUserAddress(userid);
    }

}
