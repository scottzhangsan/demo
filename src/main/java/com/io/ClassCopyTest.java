package com.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClassCopyTest {

	public static void main(String[] args) {
		   System.out.println("请输入要拷贝的文件的路径:");  
	        Scanner in = new Scanner(System.in);  
	        String source = in.next();  
	        System.out.println("请输入需要拷贝到那个位置的路径以及生成的文件名:"); 
	        String destination = in.next();  
	        in.close();  
	        CopyTextDemo(source,destination);  

	}

	private static void CopyTextDemo(String source,String destination) {  
		  
        try {  
            FileWriter fw = new FileWriter(destination);  
            FileReader fr = new FileReader(source);  
            char []  buf = new char[1024];   
            //将Denmo中的文件读取到buf数组中。  
            int num = 0;      
            while((num = fr.read(buf))!=-1) {   
                fw.write(new String(buf,0,num));  
            }  
            fr.close();  
            fw.close();  
        }  
        catch (IOException e) {  
              
        }  
    }  
}
