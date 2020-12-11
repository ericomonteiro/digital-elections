package com.github.ericomonteiro.elections.config.swagger

import com.github.ericomonteiro.elections.config.annotations.SwaggerIgnore
import com.google.common.base.Predicates
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@Configuration
class SwaggerAutoConfiguration (
    @Value("\${swagger.api.info.title}")
    val title: String,

    @Value("\${swagger.api.info.description}")
    val description: String,

    @Value("\${swagger.api.info.version}")
    val version: String)
{

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
            .apis(Predicates.not(RequestHandlerSelectors.withClassAnnotation(SwaggerIgnore::class.java)))
            .apis(Predicates.not(RequestHandlerSelectors.withMethodAnnotation(SwaggerIgnore::class.java)))
            .build().apiInfo(apiEndPointsInfo())
    }

    private fun apiEndPointsInfo(): ApiInfo =
        ApiInfoBuilder()
            .title(title)
            .description(description)
            .version(version)
            .build()
}