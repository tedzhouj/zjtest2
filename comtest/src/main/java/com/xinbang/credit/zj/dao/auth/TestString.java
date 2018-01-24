package com.xinbang.credit.zj.dao.auth;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Created by zhoujun on 2017/8/2.
 */
public class TestString {
    public static void main(String[] args) throws Exception {

//        String str = "330822198802081234";
//        System.out.println(str.substring(0,str.length()-6));
//        System.out.println(str.substring(0,str.length()-6));//330822198802
        String str = "中文";
    //  String newString =  new String(str.getBytes("ISO-8859-1"), "UTF-8");
      String newString =  new String(str.getBytes("UTF-8"), "ISO-8859-1");
        System.out.println(newString);
        String str2 =  new String(newString.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(str2);
    }

    @Test
    public void test001(){
        System.out.println(StringUtils.isBlank("a a"));



        System.out.println(StringUtils.isAnyEmpty("a a"));

    }











}
