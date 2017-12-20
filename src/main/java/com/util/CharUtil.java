package com.util;

public class CharUtil {
	 /**
     * 返回字符对应的int值.
     * 
     * @param c
     */
    public static int getInt(char c) {
        return (int) c;
    }

    /**
     * 检测是否字母
     * 
     * @param c
     * @return
     */
    public static boolean isLetterCharacter(char c) {
        return isUpperCharacter(c) || isLowerCharacter(c) ? true : false;
    }

    /**
     * 检测大写
     * 
     * @param c
     */
    public static boolean isLowerCharacter(char c) {
        return (c >= 97 && c < 123) ? true : false;
    }

    /**
     * 检测是否数字.
     * 
     * @param c
     */
    public static boolean isNumber(char c) {
        return c >= 48 && c < 58 ? true : false;
    }

    /**
     * 检测小写.
     * 
     * @param c
     */
    public static boolean isUpperCharacter(char c) {
        return (c >= 65 && c < 91) ? true : false;
    }

    private CharUtil() {// 不允许使用构造方法
        throw new RuntimeException();
    }
}
