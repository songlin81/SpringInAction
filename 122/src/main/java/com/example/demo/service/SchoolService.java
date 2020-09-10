package com.example.demo.service;

import com.example.demo.entity.School;
import java.util.List;

public interface SchoolService {
    public List<School> getSchoolList();
    public School findSchoolById(long id);
}