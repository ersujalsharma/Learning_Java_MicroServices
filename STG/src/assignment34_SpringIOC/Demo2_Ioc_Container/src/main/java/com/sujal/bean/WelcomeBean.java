package com.sujal.bean;

import org.springframework.stereotype.Component;

@Component
public class WelcomeBean {
	public String printWelcome() {
		return "Welcome to Spring";
	}
}
