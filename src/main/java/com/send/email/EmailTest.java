package com.send.email;

import java.util.ArrayList;
import java.util.List;

import com.sgm.solution.framework.core.email.exception.MailValidateException;
import com.sgm.solution.framework.core.email.resources.MailRequest;
import com.sgm.solution.framework.core.email.resources.MailResponse;
import com.sgm.solution.framework.email.client.MailSender;

public class EmailTest {
	
	public static void main(String[] args) throws MailValidateException {
		List<String> list = new ArrayList<>() ;
		//list.add("11547609609@qq.com");
		
		list.add("15837192793@163.com");

			 MailRequest req = new MailRequest();
			  MailResponse resp;
			  req.setAppId("yylolwow-4567-ui89-kiou-huji764cadbb");
			  req.setMailFrom("yazhou.zhang@dxc.com");
			  req.setMailTo(list);
			  req.setMailSubject("TEST");
			  req.setMailContent("你好");
			
			  try {
			      resp =  MailSender.send(req);
			  } catch (MailValidateException e) {
			      throw e;
			  }
	
		}
		
}
