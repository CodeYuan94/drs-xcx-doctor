package com.df.drs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2 //swagge接口文档
@EnableTransactionManagement //开启事务
@SpringBootApplication
public class DrsXcxDoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DrsXcxDoctorApplication.class, args);
    }

}
