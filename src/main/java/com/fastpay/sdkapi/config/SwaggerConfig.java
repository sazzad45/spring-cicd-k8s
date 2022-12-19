package com.fastpay.sdkapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.host("dev-apigw-sdk.fast-pay.cash")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fastpay.sdkapi.controllers"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"FastPay Payment SDK APIs",
				"APIs related to FastPay Payment SDK",
				"3.0.1",
				"Terms of service",
				new Contact("Mahfuzul Alam", "www.fast-pay.cash", "mahfuzul.alam@fast-pay.cash"),
				"License of API", "API license URL", Collections.emptyList());
	}

}
