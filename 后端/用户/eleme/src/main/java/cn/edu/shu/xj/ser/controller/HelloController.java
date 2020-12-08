package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.*;
import cn.edu.shu.xj.ser.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口")
@RestController
public class HelloController {

    @Autowired
    StudentService studentService;

    @ApiOperation(value = "查询学生")
    @GetMapping("/query")
    public Student queryStudent(Integer sid){
        Student oneStudent = studentService.findOneStudent(sid);
        return oneStudent;
    }

    @Autowired
    UserService userService;

    @ApiOperation(value = "查询用户")
    @GetMapping("/query/User")
    public user queryUser(String userid){
//        Student oneStudent = studentService.findOneStudent(sid);
        user oneuser = userService.findOneUser(userid);
        return oneuser;
    }

    @Autowired
    UserAddressService userAddressService;

    @ApiOperation(value = "查询用户地址")
    @GetMapping("/query/User/Address")
    public user_address queryUserAddress(String userid){
//        Student oneStudent = studentService.findOneStudent(sid);
        user_address oneuser_address = userAddressService.findOneUserAddress(userid);
        return oneuser_address;
    }

    @Autowired
    DiscountService discountService;

    @ApiOperation(value = "查询优惠券")
    @GetMapping("/query/Discount")
    public discount queryDiscount(String discountid){
        discount onediscount = discountService.findOneDiscount(discountid);
        return  onediscount;
    }

    @Autowired
    OrdService ordService;

    @ApiOperation(value = "查询订单")
    @GetMapping("/query/order")
    public ord queryOrder(String ordid){
        ord oneord = ordService.findOneOrder(ordid);
        return oneord;
    }
}
