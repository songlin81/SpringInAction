package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(long id);

    Student deleteById(long id);

    @Query("select a from Student a where a.id = ?1")
    Student getStudentByMySelf(long id);

    @Query(value = "select * from stdu a where a.id = ?1",nativeQuery = true)
    Student getStudentByMySelf2(long id);

    @Modifying
    @Transactional
    @Query(value = "update Student a set a.name = 'Vijay2' where a.id =:id")
    void updataUserByGuid(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update Student a set a.name = :name where a.id =:id")
    void updataStudentById(@Param("name") String name, @Param("id") long id);

}