package com.anshare.project.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * 描述：
 * <p>
 * Author: 赵新国
 * Date: 2017/12/12 15:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{

    /**
     * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
     *  <!--swagger资源配置-->
     *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     *  不知道为什么，这也是spring boot的一个缺点（菜鸟觉得的）
     * @param registry
     */


    // 设置默认TOKEN，方便测试
    private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiznrqHnkIblkZgsMDAwMDAwMDAtMTAwMC0wMDAwLTAwMDAtMDAwMDAwMDAwMDAwLDAwMDAwMDAwLTAwMDAtMDAwMS0wMDAwLTAwMDAwMDAwMDAwMCwwMDAwMDAwMC0wMDAwLTAwMDAtMDAwMC0wMDAwMDAwMDAwMDEiLCJleHAiOjE1NDk3Njc5MTJ9.cPfxY8T2134HMr5NT-m5DzXUqb-z_QTrqWQH0Teg7b532Eojbqxsgc2m3tyI2Rg2PR6Rwp8_GkyvlWW-4e7wZg";

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("auth").description("令牌").defaultValue(TOKEN).modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.anshare.project.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Error")).build(), new ResponseMessageBuilder().code(403).message("Forbidden!!!!!").build()));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Anshare RESTAPI Docs",
                "SpringBoot with Vue_Cli ",
                "v1.0",
                "Terms of service",
                new Contact("Anshare", "", ""),
                "",
                "",
                Collections.emptyList()

        );
    }
}
