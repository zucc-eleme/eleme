package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.UserAddress;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserAddressService extends IService<UserAddress> {
    UserAddress findOneUserAddress(long userId);
    UserAddress findOneUserAddressById(long addressId);
    UserAddress findOneUserMainAddress(long userId);
}
