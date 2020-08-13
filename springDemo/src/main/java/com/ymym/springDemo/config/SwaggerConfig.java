package com.ymym.springDemo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private String version;
	
	@Bean
	public Docket apiV1() {
		version = "v1";
		
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).groupName(version)
				.select().apis(RequestHandlerSelectors.basePackage("com.ymym.springDemo")).paths(PathSelectors.ant("/v1/api/**"))
                .build().apiInfo(apiInfo(version));
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo apiInfo(String version) {
		final String title = "ymym Swagger Test API Documentation";
		final String description = "YM Test Swagger API Docs";
		final Contact contact = new Contact("Contact Me", "www.ymym.com", "ymym@example.com");
		final String license = "";
		final String licenseUrl = "";
		
		final Collection<VendorExtension> vendorExtensions = Collections.emptyList();
		ApiInfo apiInfo = new ApiInfo(title, description, version, "www.ymym.com", contact, license, licenseUrl,
				vendorExtensions);

		return apiInfo;
	}
}
