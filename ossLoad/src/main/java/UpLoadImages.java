import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import java.net.URL;
import java.util.Date;

/**
 * Created by zhoujun on 2017/8/15.
 */
public class UpLoadImages {


    public static void main(String[] args) {
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";//把bucket去掉加http
        String accessKeyId = "LTAIKAReMIy8Jfs5";
        String accessKeySecret = "WczD8ty9EvSJ8S30y8HXlwOkgQGliL";
        String bucketName = "xb-oss-aliyun-check-test";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

     URL url =   ossClient.generatePresignedUrl(bucketName,"8241385777381376/163d4fe4dbdb428eae88bc75bf547844/0B10A3A7-D872-4786-865A-FF992FD98C31.jpg",new Date(new Date().getTime()+1000*3600*24), HttpMethod.GET);
        System.out.println(url);
       // ossClient.putObject( , ,  )
    }











}
