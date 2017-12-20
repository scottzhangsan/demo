package com.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) throws IOException {
		
	  @SuppressWarnings("resource")
	 FileWriter fileWriter = new FileWriter("c://1.txt") ;
	  
	  fileWriter.write("hello world");
	  
	  fileWriter.flush();
	  
	   System.out.println("写入流结束");
	   
	   fileWriter.close();
		
	}

}
