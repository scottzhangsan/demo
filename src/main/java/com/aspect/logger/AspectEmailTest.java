package com.aspect.logger;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.atguigu.crud.bean.User;
import com.sgm.solution.framework.core.email.exception.MailValidateException;
import com.sgm.solution.framework.core.email.resources.MailRequest;
import com.sgm.solution.framework.core.email.resources.MailResponse;
import com.sgm.solution.framework.email.client.MailSender;

/**
 * 
 * @author zhangyaz
 *测试发送email的Aop.
 */
@Aspect
@Component
public class AspectEmailTest {
	
	@Pointcut("execution(* com.atguigu.crud.dao.UserMapper.bathInsert(..))")
	public void  emailTest(){
		
		
	}
	
	@After("emailTest()")
	/**
	 * 增加用户后发送邮件
	 * @throws MailValidateException
	 */
	public void afterTest(JoinPoint jPoint) throws MailValidateException{
	List<User>users =	(List<User>) jPoint.getArgs()[0] ;
	
	StringBuffer sBuffer = new StringBuffer() ;
	
	for (User user : users) {
		sBuffer = sBuffer.append(user.getUsername());
	}
		System.out.println(sBuffer.toString());
		  List<String> list = new ArrayList<>() ;
		  list.add("15837192793@163.com");
	
			 MailRequest req = new MailRequest();
			  MailResponse resp;
			  req.setAppId("yylolwow-4567-ui89-kiou-huji764cadbb");
			  req.setMailFrom("1154769609@qq.com");
			  req.setMailTo(list);
			  req.setMailSubject("发送邮件测试");
			  req.setMailContent("邮件发送成功"+sBuffer.toString());
			  System.out.println("测试发送邮件成功"+sBuffer.toString());
			  try {
			      resp =  MailSender.send(req);
			  } catch (MailValidateException e) {
			      throw e;
			  }
		
		
	}

}
