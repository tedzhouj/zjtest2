package util;

import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhoujun on 2017/11/17.
 */
public class BeanCopyUtil {
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    public BeanCopyUtil() {
    }

    public static <T> T objConvert(Object obj, Class<T> toObj) {
        return null == obj ? null : dozer.map(obj, toObj);
    }

    public static void copy(Object source, Object toObj) {
        if (null != source) {
            dozer.map(source, toObj);
        }

    }

    public static <T> List<T> convertList(Collection<?> collection, Class<T> toObj) {
        if (collection == null) {
            return null;
        } else if (toObj == null) {
            return null;
        } else {
            ArrayList list = new ArrayList();
            Iterator i$ = collection.iterator();

            while (i$.hasNext()) {
                Object obj = i$.next();
                list.add(dozer.map(obj, toObj));
            }

            return list;
        }
    }
}
