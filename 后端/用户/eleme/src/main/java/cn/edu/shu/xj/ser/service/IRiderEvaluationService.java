package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.RiderEvaluation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IRiderEvaluationService extends IService<RiderEvaluation> {
    float getRiderAllStars(long riderId);
    int getRiderAllCounts(long riderId);
    List<Long> getAllUserId(long riderId);
}
