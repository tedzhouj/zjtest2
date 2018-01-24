package test.menus;

import com.moxie.commons.BaseSecurityUtils;

/**
 * Created by zhoujun on 2017/9/19.
 */
public class testMain {
    public static void main(String[] args) {


        String ss = BaseSecurityUtils.md5("18694558637");
        System.out.println(ss.toUpperCase());
        String sp = BaseSecurityUtils.aesEncrypt("xb@54321", "qwertyuiopasdfghjklzxcvbnmqazplm");
        System.out.println(sp);

    }

}
