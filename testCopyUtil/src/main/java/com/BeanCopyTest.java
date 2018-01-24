package com;

import bean.AnotherBean;
import bean.User;
import org.junit.Test;
import util.BeanCopyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhoujun on 2017/11/17.
 */
public class BeanCopyTest {

    public static String SS= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random random = new Random(1111);

    public static void main(String[] args) {

        AnotherBean anotherBean = new AnotherBean();
        anotherBean.setName("Aname");
        anotherBean.setAge("11");
        anotherBean.setBalabal("sdfsdfsd");
        anotherBean.setGender("F");
        anotherBean.setText("some thing to test");
        User user = new User();
        BeanCopyUtil.copy(anotherBean,user);
        System.out.println(user);
    }


    //copy List
    @Test
    public void test(){
        List<AnotherBean> fromList = new ArrayList();
        fromList.add(createABean());
        fromList.add(createABean());
        fromList.add(createABean());
        List<User> ToList = new ArrayList<User>();
        ToList = BeanCopyUtil.convertList(fromList,User.class);
        System.out.println(ToList);

    }


    public AnotherBean createABean(){
        AnotherBean anotherBean = new AnotherBean();
        anotherBean.setName(getARandomString());
        anotherBean.setAge("11");
        anotherBean.setBalabal("ss:"+getARandomString());
        anotherBean.setGender("F");
        anotherBean.setText("some thing to test");
        return anotherBean;
    }

    public String getARandomString(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<=5;i++){
            int t = random.nextInt(25);
            System.out.println(t);
            sb.append(SS.charAt(t));
        }
        return sb.toString();
    }





}
