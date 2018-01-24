import com.moxie.commons.BaseSecurityUtils;

/**
 * Created by zhoujun on 2017/7/19.
 */
public class testUtilASE {
    public static void main(String[] args) {
//        String pwd = "xinbang@12345";
//
//        String EncrpPwd = BaseSecurityUtils.aesEncrypt(pwd, "qwertyuiopasdfghjklzxcvbnmqazplm");
//        System.out.println(EncrpPwd);


        String pwd = "158daa795cdb2e4fbf486e8011283eb5";

        String EncrpPwd = BaseSecurityUtils.aesDecrypt(pwd, "");
        System.out.println(EncrpPwd);

    }



}
