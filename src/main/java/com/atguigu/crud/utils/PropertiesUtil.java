package com.atguigu.crud.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import com.github.pagehelper.util.PageObjectUtil;

/**
 * 
 * @author zhangyaz
 * 资源文件解析工具
 *
 */
public class PropertiesUtil {
	
	private  static Properties props ;
	
	private static final String URL_PROPERTIES_PATH = "config/url.properties";
	
	public static Map<String, String> getAllProperties(){
		
		Map<String, String> map = new HashMap<>();
		if (props==null) {
			//获取文件信息
			props = (Properties) ApplicationContextUtils.getBeanById("propertyConfigurer") ;
		}
		//获取文件的key的集合，可以进行遍历。
		Enumeration enumeration=props.propertyNames() ;
		
		
		//把文件中的key和value集合放入map中。
		if (enumeration.hasMoreElements()) {
			String key = (String) enumeration.nextElement() ;
			String value = props.getProperty(key) ;
			map.put(key, value);
		}
		
		return map ;
	}
	/**
	 * 读取文件的URL
	 * @param servicePropertityName
	 * @return
	 * @throws IOException
	 */
	public static String getServiceURL(String servicePropertityName) throws IOException{
		//读取配置文件。
		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(URL_PROPERTIES_PATH);
		
		Properties properties = new Properties() ;
		
		properties.load(inputStream);
		
		Enumeration enumeration =properties.propertyNames();
		
		while (enumeration.hasMoreElements()) {
			Object object = (Object) enumeration.nextElement();
			
			//System.out.println(properties.getProperty(object.toString()));
			
			System.out.println(object);
			
		}
		
		return null ;
	}
	/**
	 * 读取磁盘里的配置文件的信息。
	 * @param key
	 * @return
	 * @throws IOException 
	 */
	public static String getServiceURLByKey(String key) throws IOException{
		
		InputStream inputStream =PropertiesUtil.class.getClassLoader().getResourceAsStream(URL_PROPERTIES_PATH);
		Properties properties = new Properties() ;
		properties.load(inputStream);
		
		String filePath = properties.getProperty("service.propertity.name");
		File file = new File(filePath);
		
		@SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		
		String lineTxt = "";
		while ((lineTxt=bufferedReader.readLine())!=null) {
			
			System.out.println(lineTxt);
			String[] string = lineTxt.split("=");
			
			if (key.equals(string[0])) {
				return string[1] ;
			}
			
		}
		
		
		return "" ;
	}
	
public static void main(String[] args) throws IOException {
	//PropertiesUtil.getServiceURL("aa") ;
	
	System.out.println(PropertiesUtil.getServiceURLByKey("wol_vehicle_claimOrder_url")); 
}
}
