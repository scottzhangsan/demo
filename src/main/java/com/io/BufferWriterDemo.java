package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.print.DocFlavor.STRING;

public class BufferWriterDemo {

	public static void main(String[] args) throws Exception {
		FileWriter fileWriter =new FileWriter("c://3.txt") ;
		
		BufferedWriter br =new BufferedWriter(fileWriter) ;
		
		br.write("nihaoma");
		
		br.flush();
		
		br.close();
		

	}

}
