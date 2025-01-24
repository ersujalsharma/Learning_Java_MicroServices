package com.sujal.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:messages.properties")
@ComponentScan(basePackages="com.sujal.service com.sujal.repository com.sujal.controller")
public class SpringConfig {
	
	
}
