package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String body;
}
