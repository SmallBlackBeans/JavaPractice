package com.hanxiaocu.sample.jpa.简化Entity;

import javax.persistence.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 5:39 PM
 */
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Department() {
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

}
