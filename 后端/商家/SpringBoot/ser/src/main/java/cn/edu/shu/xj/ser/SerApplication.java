package cn.edu.shu.xj.ser;

import cn.edu.shu.xj.ser.entity.Store;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("cn.edu.shu.xj.ser.mapper")
@EnableSwagger2
@SpringBootApplication
public class SerApplication {
    public static Store mystore=null;
    public static void main(String[] args) {
        SpringApplication.run(SerApplication.class, args);
    }

}
