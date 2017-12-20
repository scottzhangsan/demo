package com.atguigu.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.UserMapper;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper ;

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void bathInsertUser(List<User> users) {
		
   userMapper.bathInsert(users);
	}

}
