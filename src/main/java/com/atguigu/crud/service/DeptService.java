package com.atguigu.crud.service;

import java.util.List;

import com.atguigu.crud.bean.Department;

/**
 * 
 * @author zhangyaz
 *
 */
public interface DeptService {
	
	/**
	 * 获取所有的部门信息
	 * @return
	 */
	public List<Department>  getAllDeptInfo();

}
