package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.entity.Discount;
import cn.edu.shu.xj.ser.service.IDiscountService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "优惠券模块")
@RestController
@RequestMapping("/userDiscount")
public class DiscountController {
    @Autowired
    IDiscountService discountService;
    //优惠券id不允许重复
    @ApiOperation(value = "通过优惠券id查找优惠券")
    @GetMapping("/query/discountById")
    public Discount queryDiscountById(@RequestParam(value = "discountId") String discountId){
        Discount oneDiscount = discountService.findOneDiscount(discountId);
        return oneDiscount;
    }

    //优惠券名称允许重复
    @ApiOperation(value = "通过优惠券名称查询优惠券")
    @GetMapping("/query/discountByName")
    public List<Discount> queryDiscountByName(@RequestParam(value = "discountName") String discountName){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getDiscountName,discountName);
        return discountService.list(qw);
    }

    @ApiOperation(value = "通过用户id查询优惠券")
    @GetMapping("/query/discountByUserId")
    public List<Discount> queryDiscountByUserId(@RequestParam(value = "userId") long userId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getUserId,userId);
        return discountService.list(qw);
    }

    @ApiOperation(value = "通过商家id查询优惠券")
    @GetMapping("/query/discountByStoreId")
    public List<Discount> queryDiscountByStoreId(@RequestParam(value = "storeId") long storeId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getStoreId,storeId);
        return discountService.list(qw);
    }

    @ApiOperation(value = "添加优惠券")
    @PostMapping("/add/Discount")
    public boolean addDiscount(@RequestBody Discount discount){
//    public String addDiscount(@RequestBody Discount discount){
        //如果存在相同优惠券id
        if(queryDiscountById(discount.getDiscountId())!=null)
//            return discount.getDiscountId()+"11";
            return false;
//        优惠券名称不能为空
        if(discount.getDiscountName()==null)
//            return discount.getDiscountName()+"22";
            return false;
        //起始价格不能小于0
        if(discount.getStartMoney()<=0)
//            return discount.getStartMoney()+" 33 "+discount.getDiscountMoney();
            return false;
        //优惠价格不能小于0
        if(discount.getDiscountMoney()<=0)
//            return discount.getDiscountMoney()+"44";
            return false;
        //优惠价格不能大于起始价格
        if(discount.getDiscountMoney()>discount.getStartMoney())
//            return discount.getDiscountMoney()+" "+discount.getStartMoney();
            return false;
        //用户id需要存在
        if(discount.getUserId()==0)
//            return discount.getUserId()+"55";
            return false;
//        商家id需要存在
        if(discount.getStoreId()==null)
//            return discount.getStoreId()+"66";
            return false;
//        return "chenggong";
        return discountService.saveOrUpdate(discount);
    }


    @ApiOperation(value = "删除优惠券")
    @PostMapping("/delete/Discount")
    public boolean deleteDiscount(@RequestParam(value = "discountId") String discountId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getDiscountId,discountId);
        return discountService.remove(qw);
    }

    @ApiOperation(value = "通过用户id删除优惠券")
    @PostMapping("/delete/DiscountByUserId")
    public boolean deleteDiscountByUserId(@RequestParam(value = "userId")Long userId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getUserId,userId);
        return discountService.remove(qw);
    }

    @ApiOperation(value = "通过商家id删除优惠券")
    @PostMapping("/delete/DiscountByStoreId")
    public boolean deleteDiscountByStoreId(@RequestParam(value = "storeId")Long storeId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getStoreId,storeId);
        return discountService.remove(qw);
    }

    @ApiOperation(value = "通过优惠券id删除优惠券")
    @PostMapping("/delete/DiscountById")
    public boolean deleteDiscountById(@RequestParam(value = "discountId")String discountId){
        LambdaQueryWrapper<Discount> qw = new QueryWrapper<Discount>().lambda().eq(Discount::getDiscountId,discountId);
        return discountService.remove(qw);
    }
    

}
