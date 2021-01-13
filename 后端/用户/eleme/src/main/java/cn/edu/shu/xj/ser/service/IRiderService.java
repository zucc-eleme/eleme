package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Rider;
import com.baomidou.mybatisplus.extension.service.IService;

public interface IRiderService extends IService<Rider> {
    Rider findOneRiderById(long riderId);
    Rider findOneRiderByPhone(String riderPhone);
    long getMaxRiderId();
    boolean changeRiderPwd(String riderPhone,String riderPwd);
}
