package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.RiderEvaluation;
import cn.edu.shu.xj.ser.mapper.RiderEvaluationMapper;
import cn.edu.shu.xj.ser.service.IRiderEvaluationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderEvaluationService extends ServiceImpl<RiderEvaluationMapper, RiderEvaluation> implements IRiderEvaluationService {
    @Autowired
    RiderEvaluationMapper riderEvaluationMapper;

    public float getRiderAllStars(long riderId){return riderEvaluationMapper.getRiderAllStars(riderId);}
    public int getRiderAllCounts(long riderId){return riderEvaluationMapper.getRiderAllCounts(riderId);}
    public List<Long> getAllUserId(long riderId){return riderEvaluationMapper.getAllUserId(riderId);}
}
