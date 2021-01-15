package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.UserAddress;
import cn.edu.shu.xj.ser.mapper.UserAddressMapper;
import cn.edu.shu.xj.ser.service.IUserAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressService extends ServiceImpl<UserAddressMapper, UserAddress> implements IUserAddressService {
    @Autowired
    UserAddressMapper userAddressMapper;

    public UserAddress findOneUserAddress(long userid){
        return userAddressMapper.findOneUserAddress(userid);
    }
    public UserAddress findOneUserAddressById(long addressId){return userAddressMapper.findOneUserAddressById(addressId);}
    public UserAddress findOneUserMainAddress(long userId){return userAddressMapper.findOneUserMainAddress(userId);}

}
