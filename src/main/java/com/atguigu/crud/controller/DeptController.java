package com.atguigu.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.DeptService;

/**
 * 查询部门信息的controller
 * @author zhangyaz
 *
 */
@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService ;
	@RequestMapping(value="/depts",method=RequestMethod.GET)
	@ResponseBody
    public Msg getAllDeptmentInfo(){
    	//获取所有部门信息。
    	List<Department> list =deptService.getAllDeptInfo();
    	//返回封装的对象
    	return Msg.success().add("dept", list) ;
    }
}
