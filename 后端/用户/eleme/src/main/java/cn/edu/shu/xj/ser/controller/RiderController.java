package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.entity.User;
import cn.edu.shu.xj.ser.method.Md5Utils;
import cn.edu.shu.xj.ser.service.IRiderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("骑手信息模块")
@RestController
@RequestMapping("/rider/info")
public class RiderController {
    @Autowired
    IRiderService riderService;

    @ApiOperation(value = "通过骑手电话查询骑手")
    @GetMapping("/query/riderByPhone")
    public Rider queryRiderByPhone(@RequestParam(value = "riderPhone")String riderPhone){
        Rider oneRider = riderService.findOneRiderByPhone(riderPhone);
        return oneRider;
    }

    @ApiOperation(value = "修改骑手信息")
    @PostMapping("/change/Info")
    public boolean changeinfo(@RequestBody Rider rider){
        Rider oneRider = riderService.findOneRiderByPhone(rider.getRiderPhone());
        rider.setRiderId(oneRider.getRiderId());
        return riderService.saveOrUpdate(oneRider);
    }

    @ApiOperation(value = "显示骑手位置")
    @GetMapping("/query/riderPosition")
    public String queryRiderPosition(@RequestParam(value = "riderPhone")String riderPhone){
        Rider oneRider = riderService.findOneRiderByPhone(riderPhone);
        return oneRider.getRiderPosition();
    }

    @ApiOperation(value = "骑手修改密码")
    @PostMapping("/change/riderPwd")
    public String changeUserPwd(@RequestParam(value = "riderPhone")String riderPhone,
                                @RequestParam(value = "oldPwd")String oldPwd,
                                @RequestParam(value = "riderPwd1")String riderPwd1,
                                @RequestParam(value = "riderPwd2")String riderPwd2){
        Rider oneRider = riderService.findOneRiderByPhone(riderPhone);
        if(oneRider==null)
            return "骑手不存在！";
        if(!Md5Utils.convertMD5(oldPwd).equals(oneRider.getRiderPasswd()))
            return "原密码错误！";
        if(riderPwd1==null||riderPwd2==null||!riderPwd1.equals(riderPwd2))
            return "新密码为空或者两次密码不一致！";
        if(oldPwd.equals(riderPwd1))
            return "新密码不能与原密码一致！";
        riderPwd1 = Md5Utils.convertMD5(riderPwd1);
        boolean result = riderService.changeRiderPwd(riderPhone,riderPwd1);
        String changeResult = "";
        if(result==true)
            changeResult = "修改密码成功！";
        else
            changeResult = "修改密码失败！";
        return changeResult;
    }

}
