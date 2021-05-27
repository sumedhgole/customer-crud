package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("customer-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/customer/.*"), regex("/customer/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customer API").description("Sumedh API reference for developers")
				.termsOfServiceUrl("http://sumedh.com").license("Sumedh Liscense").licenseUrl("sumedh@gmail.com")
				.version("1.0").build();
	}
}
