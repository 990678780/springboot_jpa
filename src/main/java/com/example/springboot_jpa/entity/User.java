package com.example.springboot_jpa.entity;

import javax.persistence.*;

//使用jpa注解配置映射关系
//告诉jpa这是一个实体类
@Entity
@Table(name = "user")//如果省略默认以表名小写
public class User {
    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增，默认的就是auto，根据不同的数据库选择不同的策略
    private Integer id;

    private String name;

    private String email;

    private Integer teacherId;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public User() {
    }

    public User(String name, String email, Integer teacherId) {
        this.name = name;
        this.email = email;
        this.teacherId = teacherId;
    }
}
