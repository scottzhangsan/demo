package com.sysware.demo.app.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import com.sysware.demo.app.model.RetInfo;  
import com.sysware.demo.app.service.inf.IGetInfoService;  
@WebService(endpointInterface = "com.sysware.demo.app.service.inf.IGetInfoService")  
public class GetInfoServiceImpl implements IGetInfoService  
{  
  @Autowired
	private EmployeeMapper employeeMapper ;
    @Override  
    public int add(int num1, int num2)  
    {  
        return num1 + num2;  
    }  
  
    @Override  
    public RetInfo getRetInfo(String name, int age)  
    {  
        RetInfo retInfo = new RetInfo();  
        retInfo.setAge(age);  
        retInfo.setName(name);  
        return retInfo;  
    }

	@Override
	public void addEmployee(Employee employee) {
		
		employee.setDeptId(1);
		employee.setGender("M");
		employee.setEmail("1123456@qq.com");
		employeeMapper.insertSelective(employee) ;
		
	}  

}
