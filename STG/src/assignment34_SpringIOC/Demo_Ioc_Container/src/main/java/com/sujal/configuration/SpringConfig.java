package com.sujal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.sujal.bean.WelcomeBean;


@Configuration
public class SpringConfig {
	
	@Bean(name="welcome")
	public WelcomeBean welcomeBean() {
		return new WelcomeBean();
	}

}