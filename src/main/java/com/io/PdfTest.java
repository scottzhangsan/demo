package com.io;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

public class PdfTest {

	public static void main(String[] args) throws IOException, COSVisitorException {
		 //pdf合并工具类
        PDFMergerUtility mergePdf = new PDFMergerUtility();  

        String folder = "C:\\Users\\zhangyaz\\Desktop\\pdf";  
        String destinationFileName = "pdf3.pdf";  
          
        String[] filesInFolder = getFiles(folder);     
  
        for(int i = 0; i < filesInFolder.length; i++){ 
            //循环添加要合并的pdf存放的路径
            mergePdf.addSource(folder + File.separator + filesInFolder[i]);  
        }  
        
        //设置合并生成pdf文件名称
        mergePdf.setDestinationFileName("C:\\Users\\zhangyaz\\Desktop\\" + destinationFileName);  
        //合并pdf
        mergePdf.mergeDocuments();  
        
        System.out.println("结束了！");

	}
  
	
	
	/**
	 * 获取指定文件夹下的所有的PDF文件。(所有文件。)
	 * @param folder
	 * @return
	 * @throws IOException
	 */
	 private static String[] getFiles(String folder) throws IOException {  
	      File _folder = new File(folder);  
	      String[] filesInFolder;     
	 
	      if(_folder.isDirectory()){  
	            filesInFolder = _folder.list();  
	            return filesInFolder;  
	       } else {  
	            throw new IOException("Path is not a directory");  
	       }  
	    }  
}
