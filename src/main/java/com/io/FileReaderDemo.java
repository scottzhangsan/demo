package com.io;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws Exception {
		charTest() ;

	}
	
	/**
	 *字符数组读取
	 * @throws IOException 
	 */
	public static void characters() throws IOException{
		
		FileReader fileReader =new FileReader("c://1.txt") ;
		
		//设置读取缓冲的字节输。将文件读取到buffer的数组中
		
		char[] charbuffer =new char[7];
		int num =0 ;
		
		while ((num=fileReader.read(charbuffer))!=-1) {
			System.out.println(new String(charbuffer, 0,num));
			
		}
		
		fileReader.close();
		System.out.println(charbuffer);
		System.out.println("输出结束");
	}
	/**
	 * 单个字符读取
	 */
	public static void charTest() throws Exception{
		FileReader fileReader =new FileReader("c://1.txt") ;
		
             int num =0 ;
             //read一次读取一个字符，并且自动往下读，直到达到末尾返回-1
             while((num=fileReader.read())!=-1){
            	System.out.println(num); 
             }
	   fileReader.close();
		
	}

}
