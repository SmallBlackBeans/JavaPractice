package com.hanxiaocu.JavaBean;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/21 下午4:52
 */

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * javabean 和 map 的转换
 */
public class BeanUtil {
    public static Map<String, Object> bean2map(Object bean) throws Exception {
        Map<String, Object> map = new HashMap();
        Class<?> clz = bean.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);

        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            //属性名
            String key = pd.getName();
            Method method = pd.getReadMethod();
            //属性值
            Object value = method.invoke(bean);
            map.put(key, value);
        }
        return map;
    }

    public static <T> T map2bean(Map<String, Object> map, Class<T> beanType) throws Exception {
        T newInstance = beanType.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(beanType, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : pds) {
            Method method = pd.getWriteMethod();
            String key = method.getName();

            Object value = map.get(key);
            if (value != null) {
                method.invoke(newInstance, value);
            }
        }
        return newInstance;
    }
}
