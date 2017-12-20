package com.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Null;


public class JDBCConnectionUtil {
	
	public static final String  jdbcUrl="jdbc:mysql://localhost:3306/ssm_crud";
	
	public static final String jdbcName="root";
	
	public static final String jdbcPassword ="123456" ;
	
	
	public static Connection connection =null;
	
	public static Statement statement = null ;
	
	public static Long time11 = null;
	public static Long time12= null ;
	

	
	public static void getConnection() throws ClassNotFoundException, SQLException{
		System.err.println("开始");
		time11 =System.currentTimeMillis();
		//加载指定数据库程序。
		Class.forName("com.mysql.jdbc.Driver");
		//创建数据库连接对象。
		
		connection=DriverManager.getConnection(jdbcUrl, jdbcName, jdbcPassword) ;
		
		//创建Statement对象。
		
		statement = connection.createStatement() ;
		
	}
	/**
	 * 批量插入脚本数据
	 * @throws IOException 
	 * @throws SQLException 
	 */
  public static void bathInsert() throws IOException, SQLException{
	  List<String> list =ReadSqlUtil.readSql();
	  
	  for (String string : list) {
		  String string2 =string.replace(";","") ;
		statement.execute(string2);
	}
	  time12 =System.currentTimeMillis();
	  System.out.println(time12-time11);
	 System.out.println("结束");
  }
  public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
	JDBCConnectionUtil.getConnection();
	
	JDBCConnectionUtil.bathInsert();
}
}
