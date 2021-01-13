package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IUserService extends IService<User> {
    User findOneUser(long userId);
    User findOneUserByPhone(String userPhone);
    long getMaxUserId();
    boolean changeUserPwd(String userPhone,String userPwd);
}
