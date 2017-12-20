package com.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhangyaz
 *读取SQL脚本的工具类
 */
public class ReadSqlUtil {
	
	public static List<String> readSql() throws IOException{
		List<String> list = new ArrayList<>() ;
		
		File file =new File("C:/Users/zhangyaz/Desktop/nouse/11.sql") ;
		
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		
		String lineText = "" ;
		
		while ((lineText=bReader.readLine())!=null) {
			list.add(lineText) ;
			
		}
		
		bReader.close(); 
		return list ;
	}
  public static void main(String[] args) throws IOException {
	
}
}
