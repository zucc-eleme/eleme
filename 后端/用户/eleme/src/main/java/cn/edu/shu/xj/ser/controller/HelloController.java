package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.*;
import cn.edu.shu.xj.ser.service.impl.DiscountService;
import cn.edu.shu.xj.ser.service.impl.OrdService;
import cn.edu.shu.xj.ser.service.impl.UserAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
public class HelloController {

//    @Autowired
//    StudentService studentService;
//
//    @ApiOperation(value = "查询学生")
//    @GetMapping("/query")
//    public Student queryStudent(Integer sid){
//        Student oneStudent = studentService.findOneStudent(sid);
//
//        return oneStudent;
//    }

//    @Autowired
//    UserService userService;
//
//    @ApiOperation(value = "查询用户")
//    @GetMapping("/query/User")
//    public user queryUser(Long userid){
////        Student oneStudent = studentService.findOneStudent(sid);
//        user oneuser = userService.findOneUser(userid);
////        System.out.println(oneuser);
//        return oneuser;
//    }

//    @Autowired
//    UserAddressService userAddressService;
//
//    @ApiOperation(value = "查询用户地址")
//    @GetMapping("/query/User/Address")
//    public UserAddress queryUserAddress(String userid){
////        Student oneStudent = studentService.findOneStudent(sid);
//        UserAddress oneuser_address = userAddressService.findOneUserAddress(userid);
//        return oneuser_address;
//    }
//
//    @Autowired
//    DiscountService discountService;
//
//    @ApiOperation(value = "查询优惠券")
//    @GetMapping("/query/Discount")
//    public Discount queryDiscount(String discountid){
//        Discount onediscount = discountService.findOneDiscount(discountid);
//        return  onediscount;
//    }
//
//    @ApiOperation(value = "增加优惠券")
//    @GetMapping("/insert/Discount")
//    public Discount insertDiscount(String discountid, String userid, String discountname, float discountmoney, float startmoney){
//        Discount onediscount = discountService.addOneUserDiscount(discountid,userid,discountname,discountmoney,startmoney);
//        return onediscount;
//    }
//
//    @Autowired
//    OrdService ordService;
//
//    @ApiOperation(value = "查询订单")
//    @GetMapping("/query/order")
//    public Ord queryOrder(String ordid){
//        Ord oneord = ordService.findOneOrder(ordid);
//        return oneord;
//    }


}
