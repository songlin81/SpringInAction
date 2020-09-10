package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.Set;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findById(long id);

    Student deleteById(long id);

    @Query("select a from Student a where a.name = ?1")
    Student getStudentByMySelf(String name);

    @Query(value = "select * from Student a where a.name = ?1",nativeQuery = true)
    Student getStudentByMySelf2(String name);

    @Query(value = "SELECT teacher.name FROM book.student student JOIN book.teacher_student ts on student.id=ts.s_id JOIN book.teacher teacher on teacher.id=ts.t_id where student.id=?1",nativeQuery = true)
    Set<String> getTeachersByStudent(long id);

    @Modifying
    @Transactional
    @Query(value = "update Student a set a.name = 'Vijay2' where a.id =:id")
    void updateUserByGuid(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "update Student a set a.name = :name where a.id =:id")
    void updateStudentById(@Param("name") String name, @Param("id") long id);
}