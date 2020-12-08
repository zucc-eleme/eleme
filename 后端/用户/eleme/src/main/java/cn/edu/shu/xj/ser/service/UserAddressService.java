package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.user_address;
import cn.edu.shu.xj.ser.mapper.UserAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService {

    @Autowired
    UserAddressMapper userAddressMapper;

    public user_address findOneUserAddress(String userid){
        return userAddressMapper.findOneUserAddress(userid);
    }

}
