package com.atguigu.crud.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atguigu.crud.bean.LogTestBean;
import com.atguigu.crud.dao.LogMapper;



@Aspect
@Component
public class TestAspect {
	@Autowired
	private LogMapper logMapper ;
	
	@Pointcut("execution(* com.atguigu.crud.dao.EmployeeMapper.insertSelective(..))")
    public void anyMethod(){
		
		System.out.println("1111");
	}

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }
    @After("anyMethod()")
    public void after() {
      LogTestBean logTestBean =new LogTestBean() ;
		logTestBean.setName("scott");
		logMapper.insert(logTestBean) ;
    }
    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }
    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }
    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
    	//从pjp里面可以得到环绕对象传入的参数。
    	System.out.println(pjp.getArgs()[0]);
    	
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();
        System.out.println("退出方法");
        return object;
    }
    // 顺序: before->method->after->afterReturning
		
	}


