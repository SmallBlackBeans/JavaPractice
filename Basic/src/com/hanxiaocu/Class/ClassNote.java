package com.hanxiaocu.Class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.List;

/**
 * Description: 反射机制
 * User: hanchenghai
 * Date: 2018/09/20 下午4:48
 */

class User {
    public User() {
    }

    public User(String name) {

    }

    private User(String name, int age) {

    }

    private void test(String xx) {
    }

    public static void staticM() {

    }

    public static void doWork(int... args) {
    }

    public static void doWork(String... args) {
    }

    public static <T> List<T> addList(T... args) {
        return null;
    }
}

public class ClassNote {
    public static void main(String[] args) throws Exception {
        getConstructor();
    }

    private static void getConstructor() throws Exception {
        Class<User> clazz = User.class;
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor<User> stringConstructor = clazz.getConstructor(String.class);
        stringConstructor.newInstance("xiaoheidou");

        Constructor<User> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);//私有成员 设置 可访问
        declaredConstructor.newInstance("xiaoheidou", 24);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Method method = clazz.getDeclaredMethod("test", String.class);
        method.setAccessible(true);
        Object invoke = method.invoke(clazz.newInstance(), "hahahaha"); //方法返回值

        Object date = new Date();
        Method method1 = date.getClass().getMethod("toLocaleString");
        Object result = method1.invoke(date);
        System.out.println(result);

        //invoke 对于静态方法不需要传对象,用null

        //可变参数调用
        //1.数组元素为基本类型
        Method doWork1 = clazz.getMethod("doWork", int[].class);
        Object o1 = doWork1.invoke(null, new int[]{1, 2, 3});
        Object ox = doWork1.invoke(null, new Object[]{new int[]{1, 2, 3}});
        //2.数组元素类型为引用类型
        Method doWork2 = clazz.getMethod("doWork", String[].class);
        Object o2 = doWork2.invoke(null, new Object[]{new String[]{"A", "B", "C"}});


        //泛型
        Method addList = clazz.getMethod("addList", Object[].class);
        addList.invoke(null,new Object[]{new Object[]{1}});


        //修饰符
        String s = Modifier.toString(ClassNote.class.getModifiers());
        System.out.println(s);

        System.out.println(ClassNote.class.getName());
        System.out.println(ClassNote.class.getSimpleName());
        System.out.println(ClassNote.class.getPackage().getName());

        Class<? super ClassNote> superclass = ClassNote.class.getSuperclass();
    }
}
