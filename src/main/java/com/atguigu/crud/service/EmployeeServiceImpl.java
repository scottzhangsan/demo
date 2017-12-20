package com.atguigu.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.EmployeeMapper;
import com.atguigu.crud.dao.LogMapper;
import com.atguigu.crud.dao.UserMapper;
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper ;
	@Autowired
	private LogMapper logMapper ;
	@Autowired
	private UserService userService ;

	@Override
	public List<Employee> execute() {
		
	
		
		System.out.println("任务调度123");
		logMapper.insertPro(2);
		
		return employeeMapper.selectAllEmployee();
		
		
		
		
	}

	@Override
	public int addEmployee(Employee employee) {
		
		return employeeMapper.insertSelective(employee);
	}
	@Override
	public boolean getAllEmpName(String name){
		List<String> list = employeeMapper.getAllName() ;
		if(list.size()!=0&&list!=null){
		if (list.contains(name)) {
			return false ;
		}else{
			return true ;
		}
	}else{
		return true ;
	}
		
	}

	@Override
	public Employee getEmpById(Integer id) {
		
		return employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee) ;
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	//事物的传播行为 REQURED.如果有事务在运行，当前的方法就在这个事物内运行，否则就启动一个新的事物
	//并在自己的事物内运行。
	//REQURED_NEW,当前的方法必须启动新的事物，并在他自己的事物内运行，如果有事物正在运行应该将他挂起。
	public void delEmployee(Integer id) throws Exception {
		List<User> users = new ArrayList<>() ;
		
		User user = new User() ;
		
		user.setUsername("111");
		
		user.setSex("FFF");
		
		User user2 = new User() ;
		
		user2.setUsername("222");
		
		user2.setSex("MMM");
		
		users.add(user);
		
		users.add(user2);
		
		//批量插入人员信息。
	   // userMapper.bathInsert(users);
		userService.bathInsertUser(users);
		employeeMapper.deleteByPrimaryKey(id) ;
		
		throw new Exception();
		
	}

	@Override
	public void delAllEmp(List<Integer> ids) {
		employeeMapper.delAllEmp(ids) ;
		
	} 
	
	
		
	

}
