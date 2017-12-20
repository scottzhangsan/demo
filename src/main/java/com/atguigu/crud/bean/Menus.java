package com.atguigu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class Menus {
	private String id ;
	
	private String name ;
	
	private String pid ;
	
	private String url ;
	
	private List<ChildMenus> childMenus =new ArrayList<>()  ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<ChildMenus> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<ChildMenus> childMenus) {
		this.childMenus = childMenus;
	}

	
	
	

}


