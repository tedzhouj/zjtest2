import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by zhoujun on 2017/6/8.
 */
public class OssClient {
    /**
     * OSS数据读取测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";//把bucket去掉加http
        String accessKeyId = "LTAIKAReMIy8Jfs5";
        String accessKeySecret = "WczD8ty9EvSJ8S30y8HXlwOkgQGliL";
        String bucketName = "xb-oss-aliyun-check-test";
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucketName, "07b41b50428f11e7861b00163e0e0f5e");
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
    /**
     *
     * base.oss.enabled=true
     base.oss.endpoint=oss-cn-hangzhou.aliyuncs.com
     base.oss.accessKeyId=LTAIKAReMIy8Jfs5
     base.oss.accessKeySecret=WczD8ty9EvSJ8S30y8HXlwOkgQGliL
     base.oss.bucket=xb-oss-aliyun-check-test
     base.oss.maxConn=1000
     base.oss.connTimeout=10000
     base.oss.socketTimeout=15000
     */

}
