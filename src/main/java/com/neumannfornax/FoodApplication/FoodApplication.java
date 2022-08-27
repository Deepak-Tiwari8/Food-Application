package com.neumannfornax.FoodApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}

	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("Deepak-Tiwari", "https://github.com/Deepak-Tiwari8", "deepaktiwari8226@gmail.com");
	
	ApiInfo apiInfo = new ApiInfo("Food-Application-RestApi",
			"API's to manage Food Application by the admin and foodOrder by the user",
			"Snapshoot-0.0.1",
			"https://github.com/Deepak-Tiwari8",
			contact,
			"deepaktiwari8226@gmail.com",
			"Api",
			vendorExtensions);
	
	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.neumannfornax"))
				.build()
				.apiInfo(apiInfo);
	}

}
