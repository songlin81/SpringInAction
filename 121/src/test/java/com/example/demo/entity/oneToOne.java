package com.example.demo.entity;

import com.example.demo.repository.CardRepository;
import com.example.demo.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class oneToOne {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CardRepository cardRepository;

    @Test
    public void testOneToOne() {
        Student student1 = new Student();
        student1.setName("Song");
        student1.setSex("male");
        Student student2 = new Student();
        student2.setName("Vijay");
        student2.setSex("male");

        Card card1 = new Card();
        card1.setNum(422802);
        student1.setCard(card1);
        studentRepository.save(student1);
        studentRepository.save(student2);

        Card card2 = new Card();
        card2.setNum(422803);
        cardRepository.save(card2);

        Long id = student1.getId();
        studentRepository.deleteById(id);
    }

    @Test
    public void testMore() {
        Student student1 = studentRepository.findById(2);
        Student student2 = studentRepository.getStudentByMySelf2(2);
        Student student3 = studentRepository.getStudentByMySelf(2);

        studentRepository.updataUserByGuid(2);
        studentRepository.updataStudentById("Vijay4", 4);
    }
}