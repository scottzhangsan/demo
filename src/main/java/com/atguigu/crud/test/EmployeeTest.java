package com.atguigu.crud.test;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.rewrite.RewritePolicy;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.atguigu.crud.bean.ChildMenus;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.bean.EmployeeExample;
import com.atguigu.crud.bean.EmployeeExample.Criteria;
import com.atguigu.crud.bean.Goods;
import com.atguigu.crud.bean.Menus;
import com.atguigu.crud.bean.Order;
import com.atguigu.crud.bean.User;
import com.atguigu.crud.dao.EmployeeMapper;
import com.atguigu.crud.dao.GoodsMapper;
import com.atguigu.crud.dao.UserMapper;
import com.atguigu.crud.service.EmployeeService;
import com.atguigu.crud.service.UserService;
import com.atguigu.crud.vo.ReserveVo;
import com.atguigu.crud.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EmployeeTest {

	
@Autowired	
 private EmployeeMapper employeeMapper ;
@Autowired
private UserMapper userMapper ;
@Autowired
private EmployeeService employeeService ;
@Autowired
private UserService userService ;
@Autowired
private GoodsMapper goodsMapper;
/*@Autowired(required=true)
private RestTemplate restTemplate ;*/
	/**
	 * 校验用户名是否重复
	 *
	 */
	/*@Test
	public void repateNameTest(){
		EmployeeExample employeeExample =new EmployeeExample();
		Criteria criteria =employeeExample.createCriteria() ;
		criteria.andEmpNameEqualTo("scott") ;
		
		int count = (int)employeeMapper.countByExample(employeeExample) ;
		
	}
	@Test
	public void getEmpTest(){
		Employee employee = employeeMapper.getEmpById(37) ;
		
		System.out.println(employee.getEmpName());
	}*/
	
/*	@Test
	public void addUser(){
		User user =new User() ;
		user.setAddress("河南");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setUsername("zhangsan");
		userMapper.insertUser(user);
		System.out.println("添加成功");
	}*/
	/*@Test
	public void getUser(){
		User user = new User() ;
		
		user.setUsername("");
		
		List<User> list =userMapper.getUserByName(user) ;
		
		System.out.println(list.size());
	}*/

   /* @Test
    public void getUsers(){
    	UserVo userVo = new UserVo() ;
    	List<Integer> list =new ArrayList<>() ;
    	list.add(34) ;
    	list.add(35);
    	list.add(36) ;
    	userVo.setIds(list);
    	List<User> users =userMapper.getUserByIds(userVo) ;
    	
    	System.out.println(users.size());
    }*/
  /*@Test
   public void getUserByName(){
	   
	   List<User> users =userMapper.getUserByNameLike("zhang");
	   System.out.println(users.size());
   }*/

  /*@Test
  public void getOrderbyUser(){
	  List<Order> orders =userMapper.getOrdersAndUser() ;
	  
	  System.out.println(orders.size());
	  
  }*/
/*@Test
public void getOrderList(){
	List<Order> orders =userMapper.getOrderItem();
	
	System.out.println(orders.size());
}*/
/*@Test
public void getUserInfo(){
	
	List<User> users =userMapper.getUserInfo() ;
	
	
	System.out.println(users.size());
	
}*/

/*@Test
public void getOrders(){
	
	ReserveVo vo =new ReserveVo() ;
	RestTemplate restTemplate = new RestTemplate() ;
    vo.setBeginNo(0);
    vo.setEndNo(10);
	Object object =restTemplate.postForObject("http://folsgm.saic-gm.com:8080/web.sgm/reserve/pettycashamount/query", vo, Object.class);
	
	List<Order> orders =userMapper.getOrders() ;
	
	for (Order order : orders) {
		System.out.println(order.getUser().getIds());
	}
	
	System.out.println(orders.size());
	
	
	
}*/


/*@Test
public void getMenus(){
	
	List<Menus> allMenus = userMapper.getChildMenus("U001") ;
	
	List<Menus> parentMenus = new ArrayList<>() ;
	//选择一级的菜单。
	//一级菜单的parentId为空。
	for (Menus menus : allMenus) {
		if(menus.getPid()==null){
			parentMenus.add(menus);
		}
	}
	
	//选择二级菜单。
	
for (Menus menus : allMenus) {
	if (menus.getPid()!=null) {
		for (Menus menu : parentMenus) {
			if (menu.getId().equals(menus.getPid())) {
				ChildMenus childMenus =new ChildMenus() ;
				childMenus.setId(menus.getId());
				childMenus.setUrl(menus.getUrl());
                menu.getChildMenus().add(childMenus) ;
			}
		}
	}
}
	
   for (Menus menus : parentMenus) {
	System.out.println(menus.getUrl());
}
	
}*/



/*@Test
public void userListTest(){
	List<Integer> list =new ArrayList<>();
	
	list.add(10);
	list.add(16);
	
	userMapper.listById(list, "zhangsan") ;
	
	
	System.out.println("*******结束*********");
	
	
	
}*/


/*@Test
public void insertUser(){
	List<User> users =new ArrayList<>();
	User user =new User();
	user.setUsername("asia");
	
	user.setSex("1");
	User user2 =new User() ;
	user2.setUsername("asia1");
	
	user2.setSex("2");
	users.add(user);
	users.add(user2);
	
	userMapper.insertInToUser(users);
	
	
	
}*/

/*@Test
public void updateUser(){
	User user = new User() ;
	user.setUsername("lisi");
	user.setIds(22);
  userMapper.updateUser(user);
	
}*/

/**
 * 批量更新用户信息
 */
/*@Test
public void bathUpdateUser(){
	
	
	List<User> users = new ArrayList<>() ;
	
	User user =new User();
	//user.setUsername("test1234");
	
	user.setIds(10);
	user.setSex("M");
	
	User user2 = new User() ;
	
	user2.setUsername("test1234");
	
	user2.setIds(16);
	user2.setSex("M");
	
    users.add(user);
   users.add(user2);
 
    userMapper.bathUpdates(users);
	
	
}*/

/**
 * mysql批量插入人员
 * @throws Exception 
 */
/*@Test
public void bathInsertUser() throws Exception{
	
	
    

	//employeeService.delEmployee(37);

    
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
    userMapper.bathInsert(users);
    
    System.out.println(users.size());
	
	System.out.println(9999);
	
	System.out.println(UUID.randomUUID().toString());
	
}
*/
//@Test
/*public void goodsDaoTest(){
    int goodsId = 1;
    //根据相同的id查询出商品信息，赋给2个对象
    Goods goods1 = this.goodsMapper.getGoodsById(goodsId);
    Goods goods2 = this.goodsMapper.getGoodsById(goodsId);
    
    //打印当前商品信息
    System.out.println(goods1);
    System.out.println(goods2);
    
    //更新商品信息1
    goods1.setStatus(2);//修改status为2
    int updateResult1 = this.goodsMapper.updateGoodsUseCAS(goods1);
    System.out.println("修改商品信息1"+(updateResult1==1?"成功":"失败"));
    
    //更新商品信息2
    goods1.setStatus(2);//修改status为2
    int updateResult2 = this.goodsMapper.updateGoodsUseCAS(goods1);
    System.out.println("修改商品信息2"+(updateResult2==1?"成功":"失败"));
}*/

/*@Test
public void selectByelectByExample(){
	
	//mybatis自动生成的查询方法。
	EmployeeExample s1 = new EmployeeExample();
	
	Criteria c1=s1.createCriteria();
	c1.andEmailEqualTo("1154769609@qq.com");
	
	List<Employee> list =employeeMapper.selectByExample(s1);
	
	System.out.println(list.size());
	
}*/
@Test
 public void employeeTest(){
	//1测试countByExample计算符合条件的员工的数量。
	
	EmployeeExample employeeExample = new EmployeeExample() ;
	
	Criteria criteria = employeeExample.createCriteria() ;
	
	List<Integer> list = new ArrayList<>() ;
	list.add(42);
	
	list.add(43) ;
	
	criteria.andEmpIdIn(list) ;
	
	/*long count = employeeMapper.countByExample(employeeExample);
	
	System.out.println(count);*/
	
	//2测试deleteByExample ，删除符合条件的员工的信息
	
	/*int i = employeeMapper.deleteByExample(employeeExample) ;
	
	System.out.println(i);*/
	
	//3根据条件修改员工的信息。
	
	Employee employee = new Employee() ;
	
	employee.setEmail("123");
	
	int i2 = employeeMapper.updateByExampleSelective(employee, employeeExample);
	
	System.out.println(i2);
	
	
	 
 }
}
