package com.example.springboot_jpa.repository;

import com.example.springboot_jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承jpaRepository，参数为实体类和实体类的主键类型
public interface UserRepository extends JpaRepository<User,Integer> {
}
