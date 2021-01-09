package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.service.IOrdService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/ord")
public class OrdController {
    @Autowired
    IOrdService ordService;

    @ApiOperation(value = "查询相关订单数")
    @GetMapping("/search/by/store")
    public int ordNumByStore(@RequestParam long storeId){
        LambdaQueryWrapper<Ord> qw=new QueryWrapper<Ord>().lambda().like(Ord::getStoreId,storeId);
        return ordService.count(qw);
    }

    @ApiOperation(value = "查询一定时间内的订单")
    @GetMapping("/time/by/store")
    public List<Ord> ordsBeforeTime(int day, long storeId){
        return ordService.ordsBeforeTime(day,storeId);
    }

    @ApiOperation(value = "查询某天的收益")
    @GetMapping("/profit/by/store")
    public float profitInOneDay(int day,long storeId){
        return ordService.profitInOneDay(day,storeId);
    }

    @ApiOperation(value = "查询一定时间内每天的收益")
    @GetMapping("/profits/by/store")
    public List<Float> profitsBeforeDay(int day, long storeId){
        List<Float> profits=new ArrayList<>();
        for(int i=day;i>0;i--){
            profits.add(ordService.profitInOneDay(i,storeId));
        }
        return profits;
    }
}
