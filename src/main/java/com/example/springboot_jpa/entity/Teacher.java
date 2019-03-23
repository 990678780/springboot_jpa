package com.example.springboot_jpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private Integer id;

    private String teacherName;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "teacherId")
    private Set<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Teacher() {
    }

    public Teacher(String teacherName, Set<User> users) {
        this.teacherName = teacherName;
        this.users = users;
    }

}
