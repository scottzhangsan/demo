package com.atguigu.crud.service;

import java.util.List;

import com.atguigu.crud.bean.Employee;

public interface EmployeeService {
	
	//获取所有员工信息
	public List<Employee> execute();
	
	// 新增员工
	
	public int addEmployee(Employee employee) ;
	
	//获取所有员工姓名
	public boolean getAllEmpName(String name) ;
    //根据ID获取员工信息
	public Employee getEmpById(Integer id);

	//更新员工
	public void updateEmployee(Employee employee);
	
	//删除员工
	
	public void delEmployee(Integer id) throws Exception ;

	public void delAllEmp(List<Integer> ids);

	
	
}
