package com.atguigu.crud.vo;

import java.util.List;

public class UserVo {
	
	
	private String userName ;
	
	private List<Integer> ids ;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	

}
