package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    IGoodsService goodsService;

    @ApiOperation(value = "修改商品")
    @PostMapping("/save")
    public boolean save(Goods goods){
        return goodsService.saveOrUpdate(goods);
    }

    @ApiOperation(value = "添加商品")
    @PostMapping("/add")
    public boolean add(Goods goods){

        return goodsService.saveOrUpdate(goods);
    }

    @ApiOperation(value = "删除相关商品")
    @PostMapping("/delete/by/id")
    public boolean delete(@RequestParam long goodsId){return goodsService.removeById(goodsId);}

    @ApiOperation(value = "删除相关商品")
    @PostMapping("/delete/by/class")
    public boolean delete(@RequestParam String className){
        LambdaQueryWrapper<Goods> qw=new QueryWrapper<Goods>().lambda().like(Goods::getClassName,className);
        return goodsService.remove(qw);
    }

    @ApiOperation(value = "删除相关商品")
    @PostMapping("/delete/by/store")
    public boolean deleteByStore(@RequestParam long storeId){
        LambdaQueryWrapper<Goods> qw=new QueryWrapper<Goods>().lambda().like(Goods::getStoreId,storeId);
        return goodsService.remove(qw);
    }

    @ApiOperation(value = "按商家显示商品")
    @GetMapping("/list/by/store")
    public List<Goods> list(@RequestParam long storeId){
        LambdaQueryWrapper<Goods> qw=new QueryWrapper<Goods>().lambda().like(Goods::getStoreId,storeId);
        return goodsService.list(qw);
    }

    @ApiOperation(value = "按类别显示商品")
    @GetMapping("/list/by/class")
    public List<Goods> listByClass(@RequestParam String className){
        LambdaQueryWrapper<Goods> qw=new QueryWrapper<Goods>().lambda().like(Goods::getClassName,className);
        return goodsService.list(qw);
    }

    @ApiOperation(value = "商家内按类别显示商品")
    @GetMapping("/list/by/class")
    public List<Goods> listByClassInStore(@RequestParam String className,@RequestParam long storeId){
        return goodsService.listByClassInStore(storeId,className);
    }

    @ApiOperation(value = "按商品名显示商品")
    @GetMapping("/list/by/name")
    public List<Goods> listByName(@RequestParam String goodsName){
        LambdaQueryWrapper<Goods> qw=new QueryWrapper<Goods>().lambda().like(Goods::getGoodsName,goodsName);
        return goodsService.list(qw);
    }

    @ApiOperation(value = "商家内所有类别")
    @GetMapping("/class")
    public List<String> ClassInStore(@RequestParam long storeId){
        return goodsService.classInStore(storeId);
    }
}
