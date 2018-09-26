package com.hanxiaocu.handler.impl;

import com.hanxiaocu.handler.IResultSetHandler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/26 10:16 AM
 */
public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    private Class<T> clz;

    public BeanListHandler(Class<T> clz) {
        this.clz = clz;
    }

    @Override
    public List<T> handle(ResultSet rs) {
        List<T> list = null;
        try (
                ResultSet r = rs;
        ) {
            while (r.next()) {
                T obj = clz.newInstance();
                BeanInfo info = Introspector.getBeanInfo(clz, Object.class);
                PropertyDescriptor[] pds = info.getPropertyDescriptors();
                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    Object value = r.getObject(name);
                    pd.getWriteMethod().invoke(obj, value);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
