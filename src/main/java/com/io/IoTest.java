package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class IoTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getOutPutStrem() ;
	}
	
	
	//解析文件内容输出流
	
	@SuppressWarnings("resource")
	public static void getOutPutStrem() throws IOException{
		
		File file =new File("C:/Users/zhangyaz/Desktop/pettycash_template.csv") ;
		
		BufferedReader bf = null ;
		
		FileOutputStream fileOutputStream =new FileOutputStream(file);
		
	//	BufferedReader bufferedReader =new BufferedReader(fileOutputStream)
		
		//file转化为 bufferedReader 
		bf = new BufferedReader(new FileReader(file)) ;
		String txtLine ="" ;
		while((txtLine=bf.readLine())!=null){
			
			System.out.println(txtLine);
		}
		
		
	}

}
