package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.dao.DepartmentMapper;
@Service
public class DeptServiceImpl implements DeptService {
	 
	@Autowired
	private DepartmentMapper department ;
	@Override
	public List<Department> getAllDeptInfo() {
		
		return department.selectByExample(null);
	}

}
