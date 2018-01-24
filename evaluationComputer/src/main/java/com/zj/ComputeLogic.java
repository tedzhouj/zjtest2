package com.zj;

import com.zj.compute.EvaluationException;
import com.zj.compute.Evaluator;
import com.zj.compute.newfunc.IF;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhoujun on 2017/10/9.
 */
public class ComputeLogic {


    /**
     * 计算得分
     */
    public static final String ARG_INDEX_VALUE = "value";

    public static void main(String[] args) throws Exception {

        // test1();l
         test2();
        //findIndexs("#{i4011} + #{i4012} * 2").forEach(r -> System.out.println(r));

    }

    @Test
    public void test() {

        List<String> ls = new ArrayList<>();
        String[] ss = {"1", "2", "3"};
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].equals("1")) {
                ls.add(ss[i]);
            }
            //System.out.println(ss[i]);
        }
        ls.forEach(r -> System.out.println(r));

    }


    //单一指标加工
    public static void test1() throws Exception {

        BigDecimal indexValue = new BigDecimal(1.2);
        System.out.println("test1 begin");
        String expression = "#{i4015} * 2 + 1";

        Evaluator evaluator = new Evaluator();
        evaluator.putFunction(new IF());
        evaluator.putVariable("i4015", indexValue.toString());
        String scoreStr = "";
        try {
            scoreStr = evaluator.evaluate(expression);
        } catch (EvaluationException e) {
            throw new Exception("运算出错");
        }
        System.out.println(scoreStr);
        System.out.println("test1 end");
    }

    //复合指标
    public static void test2() throws Exception {

        BigDecimal indexValue1 = new BigDecimal(1.1);
        BigDecimal indexValue2 = new BigDecimal(2.2);
        System.out.println("test2 begin");
        String expression = "#{i4011} + #{i4012} * 2";

        Evaluator evaluator = new Evaluator();
        evaluator.putFunction(new IF());
        evaluator.putVariable("i4011", indexValue1.toString());
        evaluator.putVariable("i4012", indexValue2.toString());
        String scoreStr = "";
        try {
            scoreStr = evaluator.evaluate(expression);
        } catch (EvaluationException e) {
            throw new Exception("运算出错");
        }
        System.out.println(scoreStr);
        System.out.println("test2 end");
    }


    public static List<String> findIndexs(String expression) {
        List<String> results = new ArrayList<String>();
        String ss = expression;
        int a = 0;
        int b = 0;
        while (b > -1 && ss.length() > 0) {
            a = findNextPosBegin(ss);
            b = findNextPosEnd(ss);
            if (a > 0 && b > 0)
                results.add(ss.substring(a, b));
            ss = ss.substring(b + 1);
        }
        return results;
    }

    static int findNextPosBegin(String ss) {
        return ss.indexOf("#{") + 2;
    }

    static int findNextPosEnd(String ss) {
        return ss.indexOf("}");
    }


}
