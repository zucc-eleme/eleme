package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.method.Md5Utils;
import cn.edu.shu.xj.ser.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/user/infor")
public class UserController {
    @Autowired
    IUserService userService;

    @ApiOperation(value = "用户修改信息")
    @PostMapping("/changeInfo")
    public boolean changeinfo(@RequestBody User user){
        SerApplication.currentUser = user;
        return userService.saveOrUpdate(user);
    }

    @ApiOperation(value = "用户修改密码")
    @PostMapping("/changePwd")
    public boolean changePwd(@RequestBody String pwd1,@RequestBody String pwd2){
        String pwd = Md5Utils.code(pwd1);
        if(!pwd.equals(SerApplication.currentUser.getUserPwd()))
            return false;

        String newpwd = Md5Utils.code(pwd2);
        User user = new User();
        user = SerApplication.currentUser;
        user.setUserPwd(newpwd);

        return userService.saveOrUpdate(user);
    }

}
