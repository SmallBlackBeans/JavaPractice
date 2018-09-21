package com.hanxiaocu.Introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Description: 内省
 * User: hanchenghai
 * Date: 2018/09/21 下午4:13
 */
public class IntrospectorNote {
    public static void main(String[] args) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        PropertyDescriptor[] propertys = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor property : propertys) {
            System.out.println(property.getPropertyType() +" " +  property.getName());
            if (property.getName().equals("fullName")) {
                Method method = property.getReadMethod();
                method.invoke(Person.class.newInstance());
            }
        }

    }
}
