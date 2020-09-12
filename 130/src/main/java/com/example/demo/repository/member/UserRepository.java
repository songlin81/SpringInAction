package com.example.demo.repository.member;

import com.example.demo.entity.member.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
    User findByMobile(String mobile);
    User findByEmail(String email);

    Page<User> findByIdIn(List<Integer> ids, Pageable pageable);
    List<User> findByIdIn(List<Integer> ids);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set outDate=:outDate, validataCode=:validataCode where email=:email")
    int setOutDateAndValidataCode(@Param("outDate") String outDate, @Param("validataCode") String validataCode, @Param("email") String email);

    @Modifying(clearAutomatically=true)
    @Transactional
    @Query("update User set active=:active where email=:email")
    int setActive(@Param("active") Integer active, @Param("email") String email);
}