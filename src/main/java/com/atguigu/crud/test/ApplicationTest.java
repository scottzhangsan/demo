package com.atguigu.crud.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atguigu.crud.utils.ApplicationContextUtils;
import com.atguigu.crud.utils.PropertiesUtil;

/**
 * 
 * @author zhangyaz
 *ApplicationContestUtilsTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ApplicationTest {
	
/*	@Test
 public void applicationTest(){
	 
	 PropertiesUtil.getAllProperties();
 }*/

@Test	
public  void proTest() throws IOException{
	
	PropertiesUtil.getServiceURL("11") ;
	
	System.out.println("111");
}
	
}
