package com.example.demo.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "card")
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer num;
}