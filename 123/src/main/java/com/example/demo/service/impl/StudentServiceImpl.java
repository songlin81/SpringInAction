package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudentlist() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id);
    }
}