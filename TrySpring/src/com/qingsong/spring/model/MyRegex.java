package com.qingsong.spring.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qingsong
 * created at 2018/4/17
 */
public class MyRegex {
    //纯字母
    public static String ALL_LETTER = "[a-z]+";
    //分割（空白字符）
    public static String SPILIT_SYMBOL = "\\s";
    //纯数字
    public static String ALL_NUMBER = "\\d+";
    //数字字母混合
    public static String LETTER_AND_NUMBER = "[a-zA-Z]+[a-zA-Z0-9]+";
    //运算符
    public static String OPERATOR = "<|>|<=|>=|==|=|\\*|/|\\+|\\-|\\+=|\\-=";
    //界符
    public static String BORDER_SYMBOL = "[{}]";

    public static boolean execRegex(String str,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    public static  String[] split(String str,String regex) {
        Pattern pattern = Pattern.compile(regex);
        return  pattern.split(str);
    }
    public static String replaceAllComplexSymbol(String str) {
        //暂时不支持分析的字符
        String COMPLEX_SYMBOL = "[.\"'\\[\\];\\(\\),]";
        return str.replaceAll(COMPLEX_SYMBOL," ");
    }
}
