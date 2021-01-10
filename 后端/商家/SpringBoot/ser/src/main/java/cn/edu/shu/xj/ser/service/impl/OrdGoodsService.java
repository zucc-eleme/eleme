package cn.edu.shu.xj.ser.service.impl;

import cn.edu.shu.xj.ser.entity.OrdGoods;
import cn.edu.shu.xj.ser.mapper.OrdGoodsMapper;
import cn.edu.shu.xj.ser.service.IOrdGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrdGoodsService extends ServiceImpl<OrdGoodsMapper, OrdGoods> implements IOrdGoodsService {
}
