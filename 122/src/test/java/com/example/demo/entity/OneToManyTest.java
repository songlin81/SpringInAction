package com.example.demo.entity;

import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.TeacherRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToManyTest {

    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void add() {
        School school1 = new School();
        school1.setName("UWO");
        schoolRepository.save(school1);
        Teacher teacher = new Teacher();
        teacher.setName("Doug");
        teacher.setSchool(school1);
        teacherRepository.save(teacher);
    }

    @Test
    public void find() {
        School school1 = new School();
        school1 = schoolRepository.findSchoolById(2);
        List<Teacher> teacherList = school1.getTeacherList();
        System.out.println(school1.getName());
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getName());
        }
    }

    @Test
    public void deleteSchoolById() {
        schoolRepository.deleteById(2);
    }

    @Test
    public void deleteTeacherById() {
        teacherRepository.deleteById(2);
    }
}