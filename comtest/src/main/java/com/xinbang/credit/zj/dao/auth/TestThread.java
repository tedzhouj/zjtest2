package com.xinbang.credit.zj.dao.auth;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by zhoujun on 2017/5/24.
 */
@Service
public class TestThread {


    @Async
    public void sayHello1() {
        for (int i = 0; i < 100; i++) {
            System.out.println("hello--1");
        }
    }


}
