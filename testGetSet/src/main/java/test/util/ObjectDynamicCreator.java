package test.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhoujun on 2017/11/20.
 */
public class ObjectDynamicCreator {


    /**
     * 返回由对象的属性为key,值为map的value的Map集合
     *
     * @param obj Object
     * @return mapValue Map<String,String>
     * @throws Exception
     */
    public static Map<String, String> getFieldValue(Object obj) {
        Map<String, String> mapValue = new HashMap<String, String>();
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        try {
            for (Field field : fields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    String strGet = "get" + name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
                    Method methodGet = cls.getDeclaredMethod(strGet);
                    Object object = methodGet.invoke(obj);
                    String value = object != null ? object.toString() : "";
                    mapValue.put(name, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("参数请求异常!");
        }
        return mapValue;
    }
/**
 *  Request<HttpGet> request = get(Constant.BASE_PATH, "agreements","loan","pagination");
 *  Map<String, String> map = ObjectDynamicCreator.getFieldValue(reqDto);
 *  map.entrySet().forEach(entry -> request.addParam(entry.getKey(), entry.getValue()));
 */

}
