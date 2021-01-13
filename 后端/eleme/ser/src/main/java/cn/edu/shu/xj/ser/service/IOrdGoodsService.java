package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.OrdGoods;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface IOrdGoodsService extends IService<OrdGoods> {
    float totalMoney(long ordId);
}
