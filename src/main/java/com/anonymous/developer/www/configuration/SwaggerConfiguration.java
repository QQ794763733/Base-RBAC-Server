package com.anonymous.developer.www.configuration;

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
 * @author: 肖宇
 * @QQ: 794763733
 * @WeChat: Anonymous-developer
 * @Description: Swagger配置类
 * @Datetime: 2019/9/8 8:22 下午
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    //文档标题
    private final String DOCUMENTATION_TITLE = "权限管理系统接口文档";
    //文档描述
    private final String DOCUMENTATION_DESCRIPTION = "QQ: 794763733\nWeChat: Anonymous-Developer";
    //文档URL地址
    private final String DOCUMENTATION_URL = "https://blog.anonymous-developer.cn";
    //文档版本
    private final String DOCUMENTATION_VERSION = "1.0";
    /**
     * 注册Docket
     * @return 文案信息
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.anonymous.developer.www.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return API信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(DOCUMENTATION_TITLE)
                .description(DOCUMENTATION_DESCRIPTION)
                .termsOfServiceUrl(DOCUMENTATION_URL)
                .version(DOCUMENTATION_VERSION)
                .build();
    }
}