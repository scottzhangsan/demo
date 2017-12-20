package com.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStreamTest {

	public static void main(String[] args) throws IOException {
  File file =new File("C:/Users/zhangyaz/Desktop/pettycash_template.csv") ;
		
		BufferedReader bf = null ;
		
		OutputStream fileOutputStream =new FileOutputStream(file);
		
		ByteArrayOutputStream bs = (ByteArrayOutputStream)fileOutputStream ;
	        byte[] by=	bs.toByteArray();
	        
	        ByteArrayInputStream bis =new ByteArrayInputStream(by) ;
	        
	        byte [] cs =new byte[6] ;
	        
	        int txt =0;
	        while((txt=bis.read(cs))!=-1){
	        	System.out.println(new String(cs, 0, txt));
	        }
	        

	}

}
