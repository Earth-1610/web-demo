package com.itangcent.springboot.kotlin.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    @Bean
    fun createRestApi(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.itangcent.springboot.kotlin.demo"))
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
            .title("Spring Boot Demo")
            .description("Spring Boot API Documentation Demo")
            .contact(Contact("Demo", "http://example.com", "example@example.com"))
            .version("1.0")
            .build()
    }
}