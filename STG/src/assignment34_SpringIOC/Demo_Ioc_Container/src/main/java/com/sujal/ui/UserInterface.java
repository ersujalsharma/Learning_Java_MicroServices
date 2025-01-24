package com.sujal.ui;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sujal.bean.WelcomeBean;
import com.sujal.configuration.SpringConfig;

public class UserInterface {
	public static final Log LOGGER = LogFactory.getLog(UserInterface.class); 

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		WelcomeBean welcomeBean = applicationContext.getBean(WelcomeBean.class);
		WelcomeBean welcomeBean1 = (WelcomeBean) applicationContext.getBean("welcome");
		LOGGER.info(welcomeBean.printWelcome());
		LOGGER.info(welcomeBean1.printWelcome());
	}
}
