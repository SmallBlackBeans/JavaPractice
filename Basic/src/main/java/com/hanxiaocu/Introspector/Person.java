package com.hanxiaocu.Introspector;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/21 下午4:13
 */

public class Person {
    private int age;
    private String firstname;
    private String lastname;


    //这个也是属性，属性不是字段
    public String getFullName() {
        return this.lastname + this.firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Person() {
        super();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
