package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.ReductionPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface IReductionPlanService extends IService<ReductionPlan> {
    float bestPlan(float reductionRequire);
}
