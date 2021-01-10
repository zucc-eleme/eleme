package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IOrdService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "人平均消费")
    @GetMapping("/aveConsumption")
    public float averageConsumption(Store store){
        LambdaQueryWrapper<Ord> qw=new QueryWrapper<Ord>().lambda().like(Ord::getStoreId,store.getStoreId());
        List<Ord> ords= ordService.list(qw);
        int n=0;
        float sum=0;
        for(Ord ord:ords){
            if(ord.getIsReturn()==2){
                n++;
                sum+=ord.getTotalMoney();
            }
        }
        if(n==0) return 0;
        return sum/n;
    }

    @ApiOperation(value = "添加订单")
    @PostMapping("/add")
    public boolean add(@RequestBody Ord ord){
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "修改订单")
    @PostMapping("/update")
    public boolean update(@RequestBody Ord ord){
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "删除订单")
    @PostMapping("/remove")
    public boolean remove(@RequestBody Ord ord){
        return ordService.removeById(ord.getOrdId());
    }
}
