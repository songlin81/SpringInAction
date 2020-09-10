package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private School school;
}
