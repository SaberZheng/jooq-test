package com.ecut.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * @author Amy
 * @date 2019-07-08 10:23
 * @description: Swagger2配置类
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String SWAGGER_GROUP = "jooq";

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //组名
                .groupName(SWAGGER_GROUP)
                //用它的直接参数化类型替换每个泛型类。
                .genericModelSubstitutes(DeferredResult.class)
                //是否使用默认响应消息
                .useDefaultResponseMessages(false)
                //api选择构建器。
                .select()
                //指定包路径
                .apis(basePackage("com.ecut.controllers"))
                //过滤的接口
                .paths(PathSelectors.any())
                .build().enableUrlTemplating(true)
                .apiInfo(apiInfo());
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("SpringBoot中使用Swagger2构建Restful API")
                //描述
                .description("SpringBoot整合Swagger")
                //版本
                .version("1.0")
                //作者
                .contact(new Contact("Amy", "https://www.cnblogs.com/AmyZheng/", ("aimeizheng@outlook.com")))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
