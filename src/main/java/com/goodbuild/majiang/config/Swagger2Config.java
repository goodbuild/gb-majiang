package com.goodbuild.majiang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 14:48
 * @Description:
 * @Version: 1.0.0
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("麻将")
                        .version("1.0.0")
                        .description("麻将REST文档").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.goodbuild.majiang.web"))
                .paths(PathSelectors.any())
                .build();
    }
}
