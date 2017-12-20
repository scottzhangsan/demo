package com.atguigu.crud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crud.bean.Menus;
import com.atguigu.crud.bean.Order;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.vo.UserVo;

public interface UserMapper {
	
	public int insertUser(User user) ;
	
	public List<User> getUserByName(User user) ;
	
	
	public List<User> getUserByIds(UserVo vo) ;
	
	
	public List<User> getUserByNameLike(String string);
	
	public List<Order> getOrdersAndUser() ;
	
	public List<Order> getOrderItem();
	//多对多获取用户的信息
	public List<User> getUserInfo();
	
	//延迟加载获取订单信息
	
	public List<Order> getOrders() ;
	
	/*public User getUserByIds();*/
	
	
	//延迟加载获取订单信息。
	
	public List<Menus> getChildMenus(String id) ;
	
	
	public List<User> listById(@Param("list")List<Integer> list,@Param("username")String username) ;
	
	
	public void insertInToUser(@Param("userList")List<User> list) ;
	
	
	public void updateUser(User user) ;
	
	
	public void bathUpdate(List<User> users) ;
	
	public void bathUpdates(List<User> users);
	
	//批量插入。
	
	public void bathInsert(List<User> users) ;
	
	
	

}
