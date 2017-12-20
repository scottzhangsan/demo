package com.util;


public class StringUtil {
	
	/**
	 * 传递位数不足的时候进行添加0的操作。
	 * @param string
	 * @param strLength
	 * @return
	 */
	public static String addZeroForString(String string,int strLength){
		
		int strLen = string.length() ;
		
		StringBuffer sb = null ;
		
		while (strLen<strLength) {
			sb = new StringBuffer() ;
			sb.append("0").append(string) ;
			string = sb.toString();
			strLen = string.length() ;
			
		}
		return sb.toString() ;
	}
	
	public static void main(String[] args) {
		System.out.println(StringUtil.addZeroForString("1", 7));
	}

}
