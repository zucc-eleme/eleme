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
        User oneuser = userService.findOneUserByPhone(user.getUserPhone());
        SerApplication.currentUser = user;
        user.setUserId(oneuser.getUserId());
        return userService.saveOrUpdate(user);
    }

//    @ApiOperation(value = "用户修改密码")
//    @PostMapping("/change/Pwd")
//    public boolean changePwd(@RequestBody User user,
//                             @RequestParam(value = "userPwd1")String userPwd1,
//                             @RequestParam(value = "userPwd2")String userPwd2){
//        User oneuser = userService.findOneUserByPhone(user.getUserPhone());
//        if(oneuser==null)
//            return false;
//        if(userPwd1==null||userPwd2==null||!userPwd1.equals(userPwd2))
//            return false;
//        String userPwd = Md5Utils.convertMD5(oneuser.getUserPwd());
//        if(!userPwd.equals(userPwd1))
//            return false;
//        oneuser.setUserPwd(Md5Utils.convertMD5(userPwd1));
//
//        return userService.save(oneuser);
//    }

    @ApiOperation(value = "用户修改密码(需要用户手机)")
    @PostMapping("/change/userPwd")
    public String changeUserPwd(@RequestParam(value = "userPhone")String userPhone,
                                 @RequestParam(value = "oldPwd")String oldPwd,
                                 @RequestParam(value = "userPwd1")String userPwd1,
                                 @RequestParam(value = "userPwd2")String userPwd2){
        User oneuser = userService.findOneUserByPhone(userPhone);
        if(oneuser==null)
            return "用户为空！";
        if(!Md5Utils.convertMD5(oldPwd).equals(oneuser.getUserPwd()))
            return "原密码错误！";
        if(userPwd1==null||userPwd2==null||!userPwd1.equals(userPwd2))
            return "新密码为空或者两次密码不一致！";
        if(oldPwd.equals(userPwd1))
            return "新密码不能与原密码一致！";
        userPwd1 = Md5Utils.convertMD5(userPwd1);
        boolean result = userService.changeUserPwd(userPhone,userPwd1);
        String changeResult = "";
        if(result==true)
            changeResult = "修改密码成功！";
        else
            changeResult = "修改密码失败！";
        return changeResult;
    }

//    @ApiOperation(value = "通过用户id查询用户")
//    @GetMapping("/queryByUserId")
//    public User queryByUserId(@RequestParam(value = "userId")long userId){
//        User oneuser = userService.findOneUser(userId);
//        return oneuser;
//    }


}
