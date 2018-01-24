import com.moxie.commons.BaseJsonUtils;

import java.util.Map;

/**
 * Created by zhoujun on 2017/7/11.
 */



public class TestJSON {
    public static void main(String[] args) {
        String rspbody = "{\n" +
                "  \"result_code\": \"02\",\n" +
                "  \"result_desc\": \"异常\"\n" +
                "}";

        Map<String, String> map = BaseJsonUtils.readValue(rspbody, Map.class);
        System.out.println(map.get("result_code"));
        System.out.println(map.get("result_desc"));

    }
}
