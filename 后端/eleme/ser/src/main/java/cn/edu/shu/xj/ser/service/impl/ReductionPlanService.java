package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.ReductionPlan;
import cn.edu.shu.xj.ser.mapper.ReductionPlanMapper;
import cn.edu.shu.xj.ser.service.IReductionPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReductionPlanService extends ServiceImpl<ReductionPlanMapper, ReductionPlan> implements IReductionPlanService {
    @Autowired
    ReductionPlanMapper reductionPlanMapper;
    public float bestPlan(float reductionRequire) {
        return reductionPlanMapper.bestPlan(reductionRequire);
    }
}
