package com.zj.util;

import com.google.common.collect.Lists;
import com.zj.compute.Evaluator;
import com.zj.compute.newfunc.IF;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by zhoujun on 2017/11/5.
 */
public class IndexUtil {

    public static List<String> explainIndex(String expression){
        List<String> list = Lists.newArrayList();
        int from =0;
        while (expression.indexOf("#{",from) >-1){
            int start = expression.indexOf("#{",from);
            int end = expression.indexOf("}",from);
            list.add(expression.substring(start+3,end)) ;
            from = end+1;
        }
        return list;
    }

    public static BigDecimal evaluate(String expression, Map<String, BigDecimal> map){
        Evaluator evaluator = new Evaluator();
        evaluator.putFunction(new IF());
        List<String> indexList = explainIndex(expression);
        indexList.forEach(x-> evaluator.putVariable("i"+x, String.valueOf(map.get(x) == null ? 0: map.get(x).toString())));
        String scoreStr ;
        try {
            scoreStr = evaluator.evaluate(expression);
            return new BigDecimal(scoreStr);
        } catch (Exception e) {
            System.out.println("运算出错");
        }
        return BigDecimal.ZERO;
    }


}
