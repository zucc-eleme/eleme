package cn.edu.shu.xj.ser.controller;


import cn.edu.shu.xj.ser.entity.Student;
import cn.edu.shu.xj.ser.entity.user;
import cn.edu.shu.xj.ser.service.StudentService;
import cn.edu.shu.xj.ser.service.UserService;
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
    @GetMapping("/queryUser")
    public user queryUser(String userid){
//        Student oneStudent = studentService.findOneStudent(sid);
        user oneuser = userService.findOneUser(userid);
        return oneuser;

    }

}
