package com.xinbang.credit.zj.dao.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by zhoujun on 2017/5/24.
 */
@EnableAsync
@SpringBootApplication
public class TestThreadMain {

    @Autowired
    TestThread testThread;

    @Autowired
    TestThread2 testThread2;

    public static void main(String[] args) {
        SpringApplication.run(TestThreadMain.class, args);

        TestThreadMain TestThreadMain = new TestThreadMain();
        TestThreadMain.test();
    }

    public void test(){


        for(int i=1;i<100;i++)
        {
            System.out.println("main--0");
        }
        testThread.sayHello1();
        testThread2.sayHello2();
    }


}
