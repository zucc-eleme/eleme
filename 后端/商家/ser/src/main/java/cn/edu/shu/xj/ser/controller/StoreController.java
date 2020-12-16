package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IStoreService;
import cn.edu.shu.xj.ser.service.impl.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    IStoreService storeService;

    @ApiOperation(value = "商家注册或修改信息")
    @PostMapping("/save")
    public boolean save(@RequestBody Store store){
        SerApplication.mystore=store;
        return storeService.saveOrUpdate(store);
    }

    @ApiOperation(value = "根据手机号查询商家")
    @GetMapping("/query")
    public Store getStore(String phone){
        return storeService.findOneStore(phone);
    }

    @ApiOperation(value = "删除商家")
    @PostMapping("/delete/by/id")
    public boolean remove(@RequestParam int id){
        return storeService.removeById(id);
    }

    @ApiOperation(value = "商家登录")
    @GetMapping("/login")
    public boolean login(String phone,String passwd){
        Store store=getStore(phone);
        if(store==null||!store.getStorePasswd().equals(passwd)) return false;
        System.out.println(store);
        SerApplication.mystore=store;
        return true;
    }

}
