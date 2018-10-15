package com.goodbuild.majiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author xue.l
 * @Date 2018/10/4 23:41
 * @Description: Spring Boot  启动类入口
 * @Version 1.0.0
 */
@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass =  true)
@ComponentScan(basePackages = "com.goodbuild.majiang")
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
