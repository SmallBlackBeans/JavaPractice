package com.hanxiaocu.handler.impl;

import com.hanxiaocu.handler.IResultSetHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

/**
 * Description: 处理单个结果
 * User: hanchenghai
 * Date: 2018/09/26 10:07 AM
 */
public class BeanHandler<T> implements IResultSetHandler<T> {

    private Class<T> clz;

    public BeanHandler(Class<T> clz) {
        this.clz = clz;
    }

    @Override
    public T handle(ResultSet rs) {
        T obj = null;
        try {
            ResultSet r = rs;
            if (r.next()) {
                obj = clz.newInstance();
                BeanInfo info = Introspector.getBeanInfo(clz, Object.class);

                PropertyDescriptor[] pds = info.getPropertyDescriptors();

                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();//属性名 --->  数据库列名
                    Object value = r.getObject(name);
                    pd.getWriteMethod().invoke(obj, value);//set
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
