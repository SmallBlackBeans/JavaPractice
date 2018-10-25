package com.hanxiaocu.sample.jpa.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "department")
    private Set<User> users = new HashSet<User>();

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
