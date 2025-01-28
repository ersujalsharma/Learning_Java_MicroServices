package com.sujal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;




@Configuration
@PropertySource("file:src/main/resources/messages.properties")
public class SpringConfig {
	
}