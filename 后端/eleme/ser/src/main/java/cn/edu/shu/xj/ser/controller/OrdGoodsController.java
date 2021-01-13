package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.entity.OrdGoods;
import cn.edu.shu.xj.ser.service.IOrdGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/ordGoods")
public class OrdGoodsController {
    @Autowired
    IOrdGoodsService ordGoodsService;

    @ApiOperation(value = "显示相关订单商品")
    @GetMapping("/goods/by/ord")
    public List<OrdGoods> list(long ordId){
        LambdaQueryWrapper<OrdGoods> qw=new QueryWrapper<OrdGoods>().lambda().like(OrdGoods::getOrdId,ordId);
        return ordGoodsService.list(qw);
    }

    @ApiOperation(value = "添加订单商品")
    @PostMapping("/save")
    public boolean save(@RequestBody Ord ord,@RequestBody Goods goods,int n){
        OrdGoods ordGoods=new OrdGoods(ord.getOrdId(), goods.getGoodsName(),n, goods.getGoodsPrice());
        return ordGoodsService.saveOrUpdate(ordGoods);
    }

    @ApiOperation(value = "修改订单商品")
    @PostMapping("/update")
    public boolean update(@RequestBody OrdGoods ordGoods){
        return ordGoodsService.saveOrUpdate(ordGoods);
    }

    @ApiOperation(value = "删除订单商品")
    @PostMapping("/remove")
    public boolean remove(@RequestBody OrdGoods ordGoods){
        return ordGoodsService.removeById(ordGoods.getOrdId());
    }

    @ApiOperation(value = "根据订单查看订单总额")
    @GetMapping("/totalMoney")
    public float totalMoney(@RequestParam long ordId){
        return ordGoodsService.totalMoney(ordId);

    }
}
