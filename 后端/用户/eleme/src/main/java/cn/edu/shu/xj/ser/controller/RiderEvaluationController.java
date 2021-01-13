package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.RiderEvaluation;
import cn.edu.shu.xj.ser.service.IRiderEvaluationService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Api("骑手评价模块")
@RestController
@RequestMapping("/rider/evaluation")
public class RiderEvaluationController {
    @Autowired
    IRiderEvaluationService riderEvaluationService;

    @ApiOperation(value = "显示骑手所有评价")
    @GetMapping("/query/allEvaluation")
    public List<RiderEvaluation> listAllEvaluation(@RequestParam(value = "riderId")long riderId){
        LambdaQueryWrapper<RiderEvaluation> qw = new QueryWrapper<RiderEvaluation>().lambda().like(RiderEvaluation::getRiderId,riderId);
        return riderEvaluationService.list(qw);
    }

    @ApiOperation(value = "显示骑手评分")
    @GetMapping("/query/riderStars")
    public float queryRiderStars(@RequestParam(value = "riderId")long riderId){
        int count = riderEvaluationService.getRiderAllCounts(riderId);
        float AllStars = riderEvaluationService.getRiderAllStars(riderId);
        float avgStars = AllStars / count;
        return avgStars;
    }

    @ApiOperation(value = "添加评价")
    @PostMapping("/add/evaluation")
    public String add(@RequestBody RiderEvaluation riderEvaluation){
        List<Long> allUser = riderEvaluationService.getAllUserId(riderEvaluation.getRiderId());
        //如果该用户已经进行过评价，则不予再次评价
        for(int i = 0;i<allUser.size();i++){
            if(riderEvaluation.getUserId()==allUser.get(i))
                return "您已经评价过该骑手了！";
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
//        System.out.println("格式化输出：" + sdf.format(d));

        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        System.out.println("Asia/Shanghai:" + sdf.format(d));
        riderEvaluation.setEvaluateTime(d);
        boolean result = riderEvaluationService.saveOrUpdate(riderEvaluation);
        if(result==true)
            return "评价成功！";
        else
            return "评价失败！";
    }

    @ApiOperation(value = "删除评价")
    @PostMapping("/delete/evaluation")
    public boolean delete(@RequestBody RiderEvaluation riderEvaluation){
        return riderEvaluationService.removeById(riderEvaluation.getRiderId());
    }
}
