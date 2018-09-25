package com.snkit.springbootdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfiguraiton {
	
	@Bean
	AccountLogin  retailCustomerService() {	
		
		System.out.println("   DemoConfiguraiton ===============  retailCustomerService");
		
		return new RetailCustomerService(addharValidate());
	}
	
	@Bean
	DemoValidate addharValidate() {
		
		System.out.println("   DemoConfiguraiton ===============  addharValidate");
		
		return new AddharValidate();
	}

}
