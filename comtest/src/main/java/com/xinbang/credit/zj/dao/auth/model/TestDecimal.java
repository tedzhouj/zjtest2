package com.xinbang.credit.zj.dao.auth.model;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by zhoujun on 2017/11/9.
 */
public class TestDecimal {





    @Test
    public void test001(){
        BigDecimal decimal = new BigDecimal("1110.123456");
        System.out.println(decimal);
        DecimalFormat df = new DecimalFormat("0.00%");
        System.out.println( df.format(decimal));

    }

    @Test
    public void test002(){
        BigDecimal decimal = new BigDecimal("1110.123456").divide(new BigDecimal("100"));
        System.out.println(decimal);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println( df.format(decimal));

    }

    @Test
    public void test003(){
        BigDecimal decimal = new BigDecimal("222211100.123456").divide(new BigDecimal("100"));
        System.out.println(decimal);
        DecimalFormat df = new DecimalFormat("##.##");
        System.out.println( df.format(decimal));

    }


}
