package com.atguigu.crud.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author zhangyaz
 *redis测试
 */
public class RedisTest {
	private Jedis jedis ;
	@Before
	public void setup(){
		jedis = new Jedis("127.0.0.1",6379) ;
	}
	/**
	 * redis 来操作字符串。
	 */
    @Test
	public void testString(){
		jedis.set("name", "soctt");
		
		System.out.println(jedis.get("name"));
		
		jedis.append("name", "is my lover") ;
		jedis.get("name");
		
		//jedis.del("name");
		
		System.out.println(jedis.get("name"));
		
		jedis.mset("name","zhangsan","age","27","qq","1154XXX@qq.com");
		
		jedis.incr("age");
		
	}
    /***
     * redis用来操作map。
     */
    @Test
    public void testMap(){
    	
    	Map<String, String> map = new HashMap<>();
    	map.put("name", "wang");
    	map.put("age", "25");
    	map.put("qq", "1123XX@qq.com");
    	//把map放入jedis的map类型中。
    	jedis.hmset("user", map);
    	
    	//取出user中的name。结果是一个泛型的list。
    	
    	List<String> rsmap = jedis.hmget("user", "name","age") ;
    	
    	System.out.println(rsmap);
    	
    	//删除map中的某个键值。
    	
    	jedis.hdel("user", "age");
    	
    	System.out.println(jedis.hmget("user", "age"));
    	
    	System.out.println(jedis.hlen("user"));
    	
    	System.out.println(jedis.exists("user"));
    	
    	System.out.println(jedis.hkeys("user"));
    	
    	Iterator<String> iterator  = jedis.hkeys("user").iterator();
    	
    	while (iterator.hasNext()) {
			
			String key = iterator.next() ;
			
			System.out.println(jedis.hmget("user", key));
		}
    	
    }
    /**
     * jedis操作list
     */
    @Test
    public void testList(){
    	
    	jedis.lpush("java framework", "spring") ;
    	
    	jedis.lpush("java framework", "struts") ;
    	
    	jedis.lpush("java framework", "mybatis") ;
    	
    	//取出所有的数据，jedis.lrange是按照范围取出，
    	//第一个是key ,第二个是起始位置，第三个是结束位置，
    	//jedis.llen获取长度， -1 表示取得所有。
    	
    	System.out.println(jedis.lrange("java framework", 0, -1));
    	
    }
    
    
    @Test
    public void testSet(){
    	
    	jedis.sadd("user11", "liuling") ;
    	
    	jedis.sadd("user11", "xinxin");
    	
    	//jedis.
    	
    	
    }
}
