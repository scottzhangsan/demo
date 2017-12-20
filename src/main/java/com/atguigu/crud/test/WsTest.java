package com.atguigu.crud.test;

import com.ws.Employee;
import com.ws.GetInfoServiceImplService;

/**
 * 
 * @author zhangyaz
 * webserive的test。
 */
public class WsTest {
    
	public static void main(String[] args) {
	
		//根据serviceName获取 得到相关service的信息。 get***Port方法。
		GetInfoServiceImplService getInfoServiceImpl = new GetInfoServiceImplService();
		  
		 com.ws.IGetInfoService iii  =   getInfoServiceImpl.getGetInfoServiceImplPort() ;
		 
		 Employee employee =new Employee();
		 employee.setDeptId(1);
		 
		 iii.addEmployee(employee);
		 
		
		 
    
	}

}
