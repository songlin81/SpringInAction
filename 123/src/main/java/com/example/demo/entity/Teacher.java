package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="teacher_student",joinColumns={@JoinColumn(name="t_id")},inverseJoinColumns={@JoinColumn(name="s_id")})
    private Set<Student> students;
}