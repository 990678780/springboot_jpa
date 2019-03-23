package com.example.springboot_jpa.controller;

import com.example.springboot_jpa.entity.Teacher;
import com.example.springboot_jpa.repository.TeacherRepository;
import com.example.springboot_jpa.utils.ResMessage;
import javafx.scene.chart.ValueAxis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "teacher")
public class TeacherController {
    @Autowired
    TeacherRepository repository;

    @PostMapping(value = "/add")
    public ResMessage save(@ModelAttribute Teacher teacher) {
        ResMessage resMessage = new ResMessage();
        try {
            repository.save(teacher);
            resMessage.setMessage("添加老师信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            resMessage.setCode(0);
            resMessage.setMessage(e.getMessage());
        }
        return resMessage;
    }

    @GetMapping(value = "/list")
    public List<Teacher> getList() {
        List<Teacher> teacherList = repository.findAll();
        return teacherList;
    }

    @GetMapping(value = "/{id}")
    public Teacher getTeacherById(@PathVariable("id") Integer id) {
        Teacher teacher = repository.findOne(id);
        return teacher;
    }

}
