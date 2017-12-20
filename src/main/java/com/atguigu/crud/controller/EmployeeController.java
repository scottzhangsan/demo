package com.atguigu.crud.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.Msg;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 员工相关Controller
 * @author zhangyaz
 *
 */
@Controller
public class EmployeeController {
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private EmployeeService employeeService;
	
	
	/*@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String getAllEmployee(@RequestParam(value="pn",defaultValue ="1")Integer pn,org.springframework.ui.Model model){
		PageHelper.startPage(pn, 10);
		List<Employee> list = employeeService.getAllEmployee();
		
		PageInfo pageInfo =new PageInfo<>(list,4);
		model.addAttribute("page",pageInfo);
		return "list";
		
	}*/
	
	/**
	 * 显示所有人员信息
	 * @param pn
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public Msg getAllEmployee(@RequestParam(value="pn",defaultValue ="1")Integer pn){
		PageHelper.startPage(pn, 10);
		List<Employee> list = employeeService.execute();
		PageInfo pageInfo =new PageInfo<>(list,4);
	
		return Msg.success().add("page", pageInfo) ;
		
	}
	
	/**
	 * 增加人员
	 * 添加JSR303的校验。
	 * @param employee
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value="/insertEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg addEmployee(@Validated Employee employee,BindingResult bindingResult){
		
		//进行参数相关校验
		Map<String, String> map =new HashMap<>();
		//校验结果是否有错误
		if (bindingResult.hasErrors()) {
		List<FieldError> list=bindingResult.getFieldErrors();
			for (FieldError objectError : list) {
				map.put(objectError.getField(), objectError.getDefaultMessage()) ;
			}
		         return	Msg.fail().add("filedErrors", map) ;
		}else{
			employeeService.addEmployee(employee);
			return Msg.success();
		}
		
	}
	
	/**
	 * 判断人员姓名是否重复
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/judge",method=RequestMethod.GET)
	@ResponseBody
	public Msg judgeMutileName(@RequestParam(value="empName")String name){
		boolean flag =employeeService.getAllEmpName(name) ;
		if (flag) {
			return Msg.success();
		}else{
			return Msg.fail() ;
		}
		
	}
	/**
	 * 通过ID获取员工信息
	 * 
	 * restful风格传递参数
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/emp/{id}")
	public Msg getEmpById(@PathVariable("id")Integer id){
		Employee employee = employeeService.getEmpById(id) ;
		
		return Msg.success().add("emp", employee) ;
	}
	@ResponseBody
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Msg updateEmp(Employee employee,@PathVariable("id")Integer id){
		employee.setEmpId(id);
		
		employeeService.updateEmployee(employee) ;
		return Msg.success() ;
	}
	/**
	 * 通过ID删除员工信息
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/delEmp/{empId}",method=RequestMethod.DELETE)
	public Msg delEmp(@PathVariable("empId") Integer id) throws Exception{
		employeeService.delEmployee(id);
		
		return Msg.success() ;
	}
	/**
	 * 根据IDS删除员工。
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delEmps/{ids}",method=RequestMethod.DELETE)
	public Msg delEmps(@PathVariable("ids")String ids){
		
		String [] emps =ids.split("-") ;
		
		List<Integer> list =new ArrayList<>();
		for (String string : emps) {
			list.add(Integer.valueOf(string)) ;
		}
		
		employeeService.delAllEmp(list);
		
		return Msg.success() ;
		
	}
	
}
