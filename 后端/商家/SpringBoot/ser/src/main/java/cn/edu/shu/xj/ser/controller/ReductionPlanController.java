package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.ReductionPlan;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IReductionPlanService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "满减方案接口")
@RestController
@RequestMapping("/plan")
public class ReductionPlanController {
    @Autowired
    IReductionPlanService reductionPlanService;

    @ApiOperation(value = "添加或修改满减方案")
    @PostMapping("/save")
    public String save(@RequestBody ReductionPlan reductionPlan){
        if(reductionPlanService.saveOrUpdate(reductionPlan)) return "操作成功";
        return "操作失败";
    }

    @ApiOperation(value = "删除相关满减方案")
    @PostMapping("delete/by/id")
    public String remove(@RequestParam long planId){
        if(reductionPlanService.removeById(planId)) return "删除成功";
        return "删除失败";
    }

    @ApiOperation(value = "删除相关满减方案")
    @PostMapping("/delete/by/store")
    public String removeByStore(@RequestParam long storeId){
        LambdaQueryWrapper<ReductionPlan> qw=new QueryWrapper<ReductionPlan>().lambda().like(ReductionPlan::getStoreId,storeId);
        if(reductionPlanService.remove(qw)) return "删除成功";
        return "删除失败";
    }

    @ApiOperation(value = "显示相关满减方案")
    @GetMapping("/show/by/store")
    public List<ReductionPlan> show(@RequestParam long storeId){
        LambdaQueryWrapper<ReductionPlan> qw=new QueryWrapper<ReductionPlan>().lambda().like(ReductionPlan::getStoreId,storeId);
        return reductionPlanService.list(qw);
    }

    @ApiOperation(value = "找到最优满减方案")
    @GetMapping("/search/bestPlan")
    public float bestPlan(float reMoney){
        return reductionPlanService.bestPlan(reMoney);
    }
}
