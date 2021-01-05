package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Ord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrdService extends IService<Ord> {

    List<Ord> ordsBeforeTime(int day, long storeId);

    float profitInOneDay(int day, long storeId);

    int saveVolumeBeforeTime(int day, long storeId);
}
