package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户登录模块")
@RestController
@RequestMapping("/user/login")
public class UserLoginController {
    @Autowired
    IUserService userService;

    @ApiOperation(value = "通过用户id查询用户")
    @GetMapping("/query/userId")
    public User queryUserId(long userId){
        User oneuser = userService.findOneUser(userId);
        return oneuser;
    }

    @ApiOperation(value = "通过用户电话查询用户")
    @GetMapping("/query/userPhone")
    public User queryUserPhone(String userPhone){
        User oneuser = userService.findOneUser(userPhone);
        return oneuser;
    }


    @ApiOperation(value = "用户注册或修改信息")
    @PostMapping("/register")
    public boolean save(@RequestBody User user){
        SerApplication.currentUser=user;
        return userService.saveOrUpdate(user);
    }

    @ApiOperation(value = "通过用户id删除用户")
    @PostMapping("/remove/userId")
    public boolean removeByUseid(@RequestParam long userId){
        return userService.removeById(userId);
    }

    @ApiOperation(value = "通过用户电话删除用户")
    @PostMapping("/remove/userPhone")
    public boolean removeByUserPhone(@RequestParam String userPhone){
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda().eq(User::getUserPhone,userPhone);
        return  userService.remove(qw);
    }

    @ApiOperation(value = "通过用户名删除用户")
    @PostMapping("/remove/userName")
    public boolean removeByUserName(@RequestParam String userName){
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda().eq(User::getUserName,userName);
        return userService.remove(qw);
    }

    @ApiOperation(value = "用户登录")
    @GetMapping("/login")
    public boolean login(String userPhone,String userPwd){
        User user = userService.findOneUser(userPhone);
        if(user==null||!user.getUserPwd().equals(userPwd))
            return false;
        return true;
    }




}
