package com.df.drs.base.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yuan
 * @project drs
 * @description swagger配置
 * @date 2020/5/28 9:27
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * api接口基本信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Dr.S Api")
                .description("Dr.S项目接口详细信息")
                .version("1.0")
                .license("The Apache License")
                .licenseUrl("https://www.baidu.com")
                .build();
    }

    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.df.drs"))
                .paths(PathSelectors.any())
                .build();
    }
}
