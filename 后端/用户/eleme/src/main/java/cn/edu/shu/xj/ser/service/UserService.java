package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.user;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public user findOneUser(String userid){
        return userMapper.findOneUser(userid);
    }
}
