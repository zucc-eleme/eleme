package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.method.Md5Utils;
import cn.edu.shu.xj.ser.service.IRiderService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("骑手登录模块")
@RestController
@RequestMapping("/rider/Login")
public class RiderLoginController {
    @Autowired
    IRiderService riderService;

    @ApiOperation(value = "通过骑手id查询骑手")
    @GetMapping("/query/riderById")
    public Rider queryRiderById(@RequestParam(value = "riderId")long riderId){
        Rider oneRider = riderService.findOneRiderById(riderId);
        return oneRider;
    }

    @ApiOperation(value = "通过骑手电话查询骑手")
    @GetMapping("/query/riderByPhone")
    public Rider queryRiderByPhone(@RequestParam(value = "riderPhone")String riderPhone){
        Rider oneRider = riderService.findOneRiderByPhone(riderPhone);
        return oneRider;
    }

    @ApiOperation(value = "获取最大骑手id")
    @GetMapping("/get/maxRiderId")
    public long getMaxRiderId(){
        return riderService.getMaxRiderId();
    }

    @ApiOperation(value = "骑手注册")
    @PostMapping("/register")
    public boolean register(@RequestBody Rider rider){
//      查看是否存在相同手机号码
        Rider oneRider = riderService.findOneRiderByPhone(rider.getRiderPhone());
        if(oneRider!=null)
            return false;
        String pwd = Md5Utils.convertMD5(oneRider.getRiderPasswd());
        long riderId = getMaxRiderId();
        rider.setRiderId(riderId);
        rider.setRiderPasswd(pwd);
        return riderService.save(oneRider);
    }

    @ApiOperation(value = "骑手通过电话登录")
    @GetMapping("/login/riderPhone")
    public boolean loginByRiderPhone(@RequestParam(value = "riderPhone") String riderPhone,
                                     @RequestParam(value = "riderPwd") String riderPwd){
        Rider rider = riderService.findOneRiderByPhone(riderPhone);
        if(rider==null||!Md5Utils.convertMD5(riderPwd).equals(rider.getRiderPasswd()))
            return false;
        return true;
    }

    @ApiOperation(value = "通过骑手id删除骑手")
    @PostMapping("/remove/riderId")
    public boolean removeByRiderId(@RequestParam(value = "riderId") long riderId){
        return riderService.removeById(riderId);
    }

    @ApiOperation(value = "通过骑手电话删除骑手")
    @PostMapping("/remove/riderPhone")
    public boolean removeByRiderPhone(@RequestParam(value = "riderPhone") String riderPhone){
        LambdaQueryWrapper<Rider> qw = new QueryWrapper<Rider>().lambda().eq(Rider::getRiderPhone,riderPhone);
        return  riderService.remove(qw);
    }

    @ApiOperation(value = "通过骑手名删除骑手")
    @PostMapping("/remove/riderName")
    public boolean removeByRiderName(@RequestParam(value = "riderName") String riderName){
        LambdaQueryWrapper<Rider> qw = new QueryWrapper<Rider>().lambda().eq(Rider::getRiderName,riderName);
        return  riderService.remove(qw);
    }



}
