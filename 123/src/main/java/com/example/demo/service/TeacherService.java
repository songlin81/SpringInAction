package com.example.demo.service;

import com.example.demo.entity.Teacher;
import java.util.List;

public interface TeacherService {
    public List<Teacher> getTeacherList();
    public Teacher findTeacherById(long id);
}