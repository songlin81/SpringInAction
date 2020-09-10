package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findTeacherById(long id);
    void deleteById(long id);
}