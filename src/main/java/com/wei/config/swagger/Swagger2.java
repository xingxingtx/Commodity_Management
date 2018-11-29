package com.wei.config.swagger;/**
 * Created by Administrator on 2018/11/29.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName:Swagger2配置
 * @Description: ToDo
 * @Author: pengwei
 * @Date:2018/11/29 10:05
 * @Version: 1.0
 */
    @Configuration
    @EnableSwagger2
    public class Swagger2 {
        @Value("${swagger.show}")
        private boolean swaggerShow;
        @Bean
        public Docket createRestApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .enable(swaggerShow)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.wei"))
                    .paths(PathSelectors.any())
                    .build();
        }
        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("Luis Site Swagger Restful API")
                    .description("商品管理系统 api 文档")
                    .termsOfServiceUrl("https://luischen.com/")
                    .version("1.0")
                    .build();
        }
}
