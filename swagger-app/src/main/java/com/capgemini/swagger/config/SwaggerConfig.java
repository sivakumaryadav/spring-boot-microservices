package com.capgemini.swagger.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}
 
    private Predicate<String> postPaths() {
    	// we need to specify the controller class level path ex; /api/employee
		return or(regex("/api/posts.*"), regex("/api/employee.*"));
	}

	private ApiInfo apiInfo() {
		// @formatter:off
		return new ApiInfoBuilder().title("Employee API")
				.description("Creating the Employee App")
				.termsOfServiceUrl("http://capgemini.com")
				.license("Capgemini Technologies License")
				.licenseUrl("siva.d.kumar@capgemini.com")
				.version("1.0")
				.build();
		// @formatter:on
	}
    
}