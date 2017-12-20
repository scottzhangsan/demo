package com.atguigu.crud.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils implements ApplicationContextAware{

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		setStaticApplicationContext(applicationContext);
	}

	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static Object getBeanById(String id){
		return applicationContext.getBean(id);
	}
	
	public static <T> T getBeanByType(Class<T> requiredType){
		return applicationContext.getBean(requiredType);
	}

	private static void setStaticApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtils.applicationContext = applicationContext;
	}
	
}
