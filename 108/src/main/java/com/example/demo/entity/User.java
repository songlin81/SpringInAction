package com.example.demo.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String name;
}