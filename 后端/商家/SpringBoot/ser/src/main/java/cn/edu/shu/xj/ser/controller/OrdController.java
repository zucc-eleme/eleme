package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.*;
import cn.edu.shu.xj.ser.service.IOrdService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @ApiOperation(value = "创建订单")
    @PostMapping("/add")
    public boolean add(@RequestBody Store store, @RequestBody User user){
        Ord ord=new Ord(store.getStoreId(),user.getUserId(),0,0);
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "查找订单")
    @GetMapping("/search")
    public Ord search(@RequestBody Store store, @RequestBody User user){
        return ordService.findOrd(store.getStoreId(),user.getUserId());
    }

    @ApiOperation(value = "刷新订单总额")
    @PostMapping("/fresh/totalMoney")
    public boolean totalMoney(@RequestBody Store store, @RequestBody User user){
        Ord ord=ordService.findOrd(store.getStoreId(),user.getUserId());
        if(ord==null){
            ordService.saveOrUpdate(new Ord(store.getStoreId(),user.getUserId(),0,0));
            ord=ordService.findOrd(store.getStoreId(),user.getUserId());
        }
        OrdGoodsController ordGoodsController=new OrdGoodsController();
        ord.setTotalMoney(ordGoodsController.totalMoney(ord));
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "刷新订单满减")
    @PostMapping("/fresh/plan")
    public boolean plan(@RequestBody Store store, @RequestBody User user){
        Ord ord=ordService.findOrd(store.getStoreId(),user.getUserId());
        if(ord==null){
            ordService.saveOrUpdate(new Ord(store.getStoreId(),user.getUserId(),0,0));
            ord=ordService.findOrd(store.getStoreId(),user.getUserId());
        }
        ReductionPlanController reductionPlanController=new ReductionPlanController();
        ord.setTotalDiscount(reductionPlanController.bestPlan(ord.getTotalMoney()));
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "刷新订单折扣")
    @PostMapping("/fresh/discount")
    public boolean plan(@RequestBody Discount discount,@RequestBody Ord ord){
        ord.setTotalDiscount(ord.getTotalDiscount()+ discount.getDiscountMoney());
        return ordService.saveOrUpdate(ord);
    }

    @ApiOperation(value = "修改订单状态")
    @PostMapping("/state")
    public boolean state(@RequestBody Ord ord, int n){
        ord.setIsReturn(n);
        if(n==1) ord.setOrdTime(new Date(System.currentTimeMillis()));
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
