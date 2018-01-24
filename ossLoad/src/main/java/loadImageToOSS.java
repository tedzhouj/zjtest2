import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhoujun on 2017/8/15.
 */
public class loadImageToOSS {

    public static void main(String[] args) throws Throwable {


        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";//把bucket去掉加http
        String accessKeyId = "LTAIKAReMIy8Jfs5";
        String accessKeySecret = "WczD8ty9EvSJ8S30y8HXlwOkgQGliL";
        String bucketName = "xb-oss-aliyun-check-test";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucketName, "00002962d8a54d8fbd91537cf524cbfd");
        // 读Object内容
        System.out.println("Object content:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(ossObject.getObjectContent()));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println("\n" + line);
        }
        reader.close();
        // 关闭client
        ossClient.shutdown();


    }
}
