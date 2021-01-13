package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.Rider;
import cn.edu.shu.xj.ser.mapper.RiderMapper;
import cn.edu.shu.xj.ser.service.IRiderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RiderService extends ServiceImpl<RiderMapper, Rider> implements IRiderService {
    @Autowired
    RiderMapper riderMapper;

    public Rider findOneRiderById(long riderId){return riderMapper.findOneRiderById(riderId);}
    public Rider findOneRiderByPhone(String riderPhone){return riderMapper.findOneRiderByPhone(riderPhone);}
    public long getMaxRiderId(){return riderMapper.getMaxRiderId();}
    public boolean changeRiderPwd(String riderPhone,String riderPwd){return riderMapper.changeRiderPwd(riderPhone,riderPwd);}
}
