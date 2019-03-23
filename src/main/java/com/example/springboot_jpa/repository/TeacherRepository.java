package com.example.springboot_jpa.repository;

import com.example.springboot_jpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}