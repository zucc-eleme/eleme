package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.entity.UserAddress;
import cn.edu.shu.xj.ser.service.IUserAddressService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户地址模块")
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {
    @Autowired
    IUserAddressService userAddressService;

    @ApiOperation(value = "通过用户id查询地址")
    @GetMapping("/query/userId")
    public UserAddress queryUserAddressByUserId(long userId){
        UserAddress oneuser = userAddressService.findOneUserAddress(userId);
        return oneuser;
    }

    @ApiOperation(value = "通过addressid查询用户地址")
    @GetMapping("/query/addressId")
    public UserAddress queryUserAddress(long addressId){
        UserAddress oneuser = userAddressService.findOneUserAddressById(addressId);
        return oneuser;
    }

    @ApiOperation(value = "通过用户id查询用户主地址")
    @GetMapping("/query/mainAddress")
    public UserAddress queryMainAddressByUserId(@RequestParam(value = "userId") long userId){
        UserAddress oneuser = userAddressService.findOneUserMainAddress(userId);
        return oneuser;
    }

    @ApiOperation(value = "新增用户地址")
    @PostMapping("/add")
    public boolean addUserAddress(@RequestBody UserAddress userAddress){
        //主地址存在则不能设置为主地址
        if(userAddress.getMainAddress()==1)
            if(queryMainAddressByUserId(userAddress.getUserId())!=null)
                return false;
        return userAddressService.saveOrUpdate(userAddress);
    }

    @ApiOperation(value = "修改用户地址")
    @PostMapping("/change")
    public boolean changeUserAddress(@RequestBody UserAddress userAddress){
        if(userAddress.getMainAddress()==1)
            if(queryMainAddressByUserId(userAddress.getUserId())!=null)
                return false;
        return userAddressService.save(userAddress);
    }

    @ApiOperation(value = "通过用户id删除用户地址")
    @GetMapping("/delete/userId")
    public boolean deleteUserAddressByUserId(@RequestParam(value = "userId")long userId){
        LambdaQueryWrapper<UserAddress> qw = new QueryWrapper<UserAddress>().lambda().eq(UserAddress::getUserId,userId);
        return userAddressService.remove(qw);
    }

    @ApiOperation(value = "通过地址id删除地址")
    @GetMapping("/delete/addressId")
    public boolean deleteUserAddressByAddressId(@RequestParam(value = "addressId")long addressId){
        LambdaQueryWrapper<UserAddress> qw = new QueryWrapper<UserAddress>().lambda().eq(UserAddress::getAddressId,addressId);
        return userAddressService.remove(qw);
    }

    @ApiOperation(value = "通过用户id删除主地址")
    @GetMapping("/delete/mainAddress")
    public boolean deleteUserMainAddress(@RequestParam(value = "userId")long userId){
        LambdaQueryWrapper<UserAddress> qw = new QueryWrapper<UserAddress>().lambda().eq(UserAddress::getUserId,userId);
        qw = qw.eq(UserAddress::getMainAddress,1);
        return userAddressService.remove(qw);
    }



}
