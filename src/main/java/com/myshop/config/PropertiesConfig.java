package com.myshop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
//@ComponentScan(basePackages = "com.myshop")
@PropertySources({
//	@PropertySource("application.properties"),
	@PropertySource("credentials.properties")
})
public class PropertiesConfig {

}
