package cn.hellomyheart.kataba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @description Swagger配置类
 * @className: SwaggerController
 * @package: cn.hellomyheart.kataba.config
 * @author: Stephen Shen
 * @date: 2020/10/19 下午3:41
 */
@Configuration //标记这是一个配置
@EnableSwagger2 //启用Swagger
public class SwaggerConfig {

    private ApiInfo createAI(){
        return new ApiInfoBuilder().title("图床项目的在线接口文档").//设置标题
                contact(new Contact("Stephen Shen","http://kataba.hellomyheart.cn","stepenshen@foxmail.com"))
                .version("0.0.1").description("这是一个在线接口文档，可以直接查看接口的信息并且可以实现接口的测试")
                .build();
    }
    //构建Swagger 对象
    @Bean //使用Spring IOC创建实例
    public Docket createD(){
        return new Docket(DocumentationType.SWAGGER_2).//指定生成那种类型的文档
                apiInfo(createAI())//文档信息
                .select().apis(RequestHandlerSelectors.basePackage("cn.hellomyheart.kataba.controller")).//扫描接口所在的包
                build();
    }
}
