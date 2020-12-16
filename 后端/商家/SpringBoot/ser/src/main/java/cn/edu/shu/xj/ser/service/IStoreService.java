package cn.edu.shu.xj.ser.service;

import cn.edu.shu.xj.ser.entity.Store;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IStoreService extends IService<Store> {

    Store findOneStore(String phone);

}
