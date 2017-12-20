package com.aspect.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspectTest {
	
	//前置通知，在方法执行之前的通知。
	//第一个*代表任意的修饰符合任意的返回值，参数列表里面的..代表匹配任何数量的参数。
	//切入点的表达式可以用||来进行连接。
	@Before(value="execution(* com.atguigu.crud.dao.UserMapper.bathInsert(..)) || execution(* com.atguigu.crud.dao.UserMapper.bathUpdates(..))")
	public void loggerBefore(){
		System.out.println("--——————————》方法的前置通知");
		
	}
	
	
	@After("execution(* com.atguigu.crud.dao.UserMapper.bathInsert(..))")
	//通过joinPoint可以获得方法的名字和方法所传递的参数。
	public void loggerAfter(JoinPoint jp){
		
		System.out.println("--》方法的后置通知"+jp.getSignature().getName()+jp.getArgs());
	}

}
