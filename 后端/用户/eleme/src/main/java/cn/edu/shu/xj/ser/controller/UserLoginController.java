package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.method.Md5Utils;
import cn.edu.shu.xj.ser.service.IUserService;
import cn.edu.shu.xj.ser.service.impl.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD2;

import java.util.List;

@Api(tags = "用户登录模块")
@RestController
@RequestMapping("/user/Login")
public class UserLoginController {
    @Autowired
    IUserService userService;

    @ApiOperation(value = "通过用户id查询用户")
    @GetMapping("/query/userId")
    public User queryUserId(long userId){
        User oneuser = userService.findOneUser(userId);
        String pwd = Md5Utils.convertMD5(oneuser.getUserPwd());
        oneuser.setUserPwd(pwd);
        return oneuser;
    }

    @ApiOperation(value = "通过用户电话查询用户")
    @GetMapping("/query/userPhone")
    public User queryUserPhone(String userPhone){
        User oneuser = userService.findOneUserByPhone(userPhone);
        String pwd = Md5Utils.convertMD5(oneuser.getUserPwd());
        oneuser.setUserPwd(pwd);
        return oneuser;
    }

    //之后修改
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public boolean register(@RequestBody User user){
//      查看是否存在相同手机号码
        User oneuser = userService.findOneUserByPhone(user.getUserPhone());
        if(oneuser!=null)
            return false;
        String pwd = Md5Utils.convertMD5(user.getUserPwd());
        long userId = getMaxUserId();
        user.setUserId(userId);
        user.setUserPwd(pwd);
        SerApplication.currentUser=user;
        return userService.save(user);
    }


//    @ApiOperation(value = "用户注册")
//    @PostMapping("/register")
//    public ModelAndView register(@RequestBody String userName,@RequestBody String userPhone,
//                                 @RequestBody String userPwd, @RequestBody String userPwd2,
//                                 @RequestBody int userSex){
//        ModelAndView success = new ModelAndView();
////        用户名或密码为空的判断
//        if(userName.isEmpty()||userPhone.isEmpty()){
//            success.setViewName("register");
//            success.addObject("tips1","用户名或密码不能为空");
//            return success;
//        }
////        用户电话为空的判断
//        if(userPhone.isEmpty()){
//            success.setViewName("register");
//            success.addObject("tips2","用户电话不能为空");
//            return success;
//        }
////        两次密码不一致
//        if(!userPwd.equals(userPwd2)){
//            success.setViewName("register");
//            success.addObject("tips3","两次密码不一致");
//            return success;
//        }
////        判断数据库中是否存在用户
//        User oneuser = userService.findOneUserByPhone(userPhone);
//        if(oneuser==null){
//            User newuser = new User();
//            //对密码进行md5加密,然后保存到数据库中
//            String pwd = Md5Utils.code(userPwd);
//            newuser.setUserName(userName);
//            newuser.setUserPhone(userPhone);
//            newuser.setUserPwd(pwd);
//            newuser.setUserSex(userSex);
//            userService.save(newuser);
//            success.setViewName("success");
//        }
//        else
//            success.setViewName("404");
//        return success;
//    }

    @ApiOperation(value = "获取最大用户id")
    @GetMapping("/get/maxUserId")
    public long getMaxUserId(){
        return userService.getMaxUserId();
    }

    @ApiOperation(value = "通过用户id删除用户")
    @PostMapping("/remove/userId")
    public boolean removeByUseId(@RequestParam(value = "userId") long userId){
        return userService.removeById(userId);
    }

    @ApiOperation(value = "通过用户电话删除用户")
    @PostMapping("/remove/userPhone")
    public boolean removeByUserPhone(@RequestParam(value = "userPhone") String userPhone){
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda().eq(User::getUserPhone,userPhone);
        return  userService.remove(qw);
    }

    @ApiOperation(value = "通过用户名删除用户")
    @PostMapping("/remove/userName")
    public boolean removeByUserName(@RequestParam(value = "userName") String userName){
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda().eq(User::getUserName,userName);
        return userService.remove(qw);
    }

    @ApiOperation(value = "用户通过电话登录")
    @GetMapping("/login/userPhone")
    public boolean loginByUserPhone(@RequestParam(value = "userPhone") String userPhone, @RequestParam(value = "userPwd") String userPwd){
        User user = userService.findOneUserByPhone(userPhone);
//        if(user==null||!Md5Utils.code(userPwd).equals(user.getUserPwd()))
        if(user==null||!Md5Utils.convertMD5(userPwd).equals(user.getUserPwd()))
            return false;
        SerApplication.currentUser = user;
        return true;
    }



}
