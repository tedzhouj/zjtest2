package com.xinbang.credit.zj.dao.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhoujun on 2017/5/10.
 */
@SpringBootApplication
@RestController
public class TestMain
{
    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    @RequestMapping("/")
    public String greeting() {
        return "Index Page";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
