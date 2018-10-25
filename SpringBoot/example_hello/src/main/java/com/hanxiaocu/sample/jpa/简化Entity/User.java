package com.hanxiaocu.sample.jpa.简化Entity;


import javax.persistence.*;
import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 5:37 PM
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键生成策略  自增
    private Integer id;

    @Column
    private  String name;

    @Column(name = "create_time")
    private Date createTime;


    @Column(name = "department_id")
    Integer departmentId;


    //JPA 要求实体必须又一个空的构造函数
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

}
