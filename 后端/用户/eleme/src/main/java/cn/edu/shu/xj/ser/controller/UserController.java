package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.method.Md5Utils;
import cn.edu.shu.xj.ser.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户模块")
@RestController
@RequestMapping("/user/infor")
public class UserController {
    @Autowired
    IUserService userService;

    @ApiOperation(value = "用户修改信息")
    @PostMapping("/change/Info")
    public boolean changeinfo(@RequestBody User user){
        SerApplication.currentUser = user;
        return userService.saveOrUpdate(user);
    }

    @ApiOperation(value = "用户修改密码")
    @PostMapping("/change/Pwd")
    public boolean changePwd(@RequestBody String pwd1,@RequestBody String pwd2){
        String pwd = Md5Utils.code(pwd1);
        if(pwd==null)
            return false;
        if(!pwd.equals(SerApplication.currentUser.getUserPwd()))
            return false;

        String newpwd = Md5Utils.code(pwd2);
        User user;
        user = SerApplication.currentUser;
        user.setUserPwd(newpwd);

        return userService.saveOrUpdate(user);
    }

//    @ApiOperation(value = "通过用户id查询用户")
//    @GetMapping("/queryByUserId")
//    public User queryByUserId(@RequestParam(value = "userId")long userId){
//        User oneuser = userService.findOneUser(userId);
//        return oneuser;
//    }


}
