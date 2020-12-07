package cn.edu.shu.xj.ser.service;


import cn.edu.shu.xj.ser.entity.Student;
import cn.edu.shu.xj.ser.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public Student findOneStudent(Integer sid){
        return studentMapper.findOneStudent(sid);
    }

}
