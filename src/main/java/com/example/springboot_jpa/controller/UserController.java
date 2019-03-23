package com.example.springboot_jpa.controller;

import com.example.springboot_jpa.repository.TeacherRepository;
import com.example.springboot_jpa.utils.ResMessage;
import com.example.springboot_jpa.entity.User;
import com.example.springboot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "user")
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    @GetMapping("/list")
    public List<User> getUserList() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    //Swagger要传送对象作为参数，只需添加@ModelAttribute
    @PostMapping("/user")
    public ResMessage addUser(@ModelAttribute User user) {
        //返回合适的提示信息
        ResMessage resMessage = new ResMessage();
        try {
            User save = userRepository.save(user);
        } catch (Exception e) {
            resMessage.setCode(0);
            resMessage.setMessage(e.getMessage());
        }
        return resMessage;
    }

    @PutMapping("/updateTeacherId")
    public ResMessage updateTeacherId(int userId, int teacherId) {
        //返回合适的提示信息
        ResMessage resMessage = new ResMessage();
        try {
            User user = userRepository.findOne(userId);
            user.setTeacherId(teacherId);
            User save = userRepository.save(user);
        } catch (Exception e) {
            resMessage.setCode(0);
            resMessage.setMessage(e.getMessage());
        }
        return resMessage;
    }
}
