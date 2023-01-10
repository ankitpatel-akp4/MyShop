package com.myshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;






@SpringBootApplication
public class MyShopApplication {
	@Autowired
	private UserDetailsService userDetailsService;
	public static void main(String[] args) {
		SpringApplication.run(MyShopApplication.class, args);
	}
	@Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	 }
	@Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
}
