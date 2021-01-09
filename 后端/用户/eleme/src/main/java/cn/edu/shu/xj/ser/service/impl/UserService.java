package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.mapper.UserMapper;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    public User findOneUser(long userId){
        return userMapper.findOneUser(userId);
    }
    public User findOneUserByPhone(String userPhone){return userMapper.findOneUserByPhone(userPhone);}
    public long getMaxUserId(){return userMapper.getMaxUserId();}
}
