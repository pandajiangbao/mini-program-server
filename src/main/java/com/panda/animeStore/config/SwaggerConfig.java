package com.panda.animeStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singletonList;
import static springfox.documentation.swagger.web.ApiKeyVehicle.HEADER;

/**
 * @author panda
 * @date 2019/1/28
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.panda.animeStore.controller"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(singletonList(new ApiKey("JWT", "token", HEADER.name())))
                .securityContexts(singletonList(
                        SecurityContext.builder()
                                .securityReferences(
                                        singletonList(SecurityReference.builder()
                                                .reference("JWT")
                                                .scopes(new AuthorizationScope[0])
                                                .build()
                                        )
                                )
                                .forPaths(PathSelectors.regex("^((?!login).)*$"))
                                .build())
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("AnimeStore在线API文档")
                .description("胖达天下第一")
                .contact(new Contact("胖达酱", "https://pandajiang.cn",
                        "pandawsh@icloud.com"))
                .version("1.0")
                .build();
    }
}