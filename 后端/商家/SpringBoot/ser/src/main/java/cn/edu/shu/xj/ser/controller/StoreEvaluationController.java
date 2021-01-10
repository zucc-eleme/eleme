package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.GoodsEvaluation;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IGoodsEvaluationService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/storeEvaluation")
public class StoreEvaluationController {
    @Autowired
    IGoodsEvaluationService goodsEvaluationService;

    @ApiOperation(value = "按商家显示评价")
    @GetMapping("/listEvaluations")
    public List<GoodsEvaluation> list(long storeId){
        LambdaQueryWrapper<GoodsEvaluation> qw=new QueryWrapper<GoodsEvaluation>().lambda().like(GoodsEvaluation::getStoreId,storeId);
        return goodsEvaluationService.list(qw);
    }

    @ApiOperation(value = "商家评分")
    @GetMapping("/storeRating")
    public float storesRating(Store store){
        LambdaQueryWrapper<GoodsEvaluation> qw=new QueryWrapper<GoodsEvaluation>().lambda().like(GoodsEvaluation::getStoreId,store.getStoreId());
        List<GoodsEvaluation> evaluations= goodsEvaluationService.list(qw);
        int n=goodsEvaluationService.count(qw);
        if(n==0) return 0;
        float sum=0;
        for(GoodsEvaluation goodsEvaluation:evaluations){
            sum+=goodsEvaluation.getEvaluationStar();
        }
        return sum/n;
    }

    @ApiOperation(value = "添加评价")
    @PostMapping("/add")
    public String add(@RequestBody GoodsEvaluation goodsEvaluation){
        if(goodsEvaluationService.saveOrUpdate(goodsEvaluation)) return "评价成功";
        return "评价失败";
    }

    @ApiOperation(value = "删除评价")
    @PostMapping("/remove")
    public String remove(@RequestBody GoodsEvaluation goodsEvaluation){
        if(goodsEvaluationService.removeById(goodsEvaluation.getEvaluateId())) return "删除成功";
        return "删除失败";
    }
}
