package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecuritySimpleDemoApplicationTests {

	@Test
	public void contextLoads() {
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		String encodePassword = encoder.encode("Song");
		System.out.println(encodePassword);
		encodePassword = encoder.encode("123456");
		System.out.println(encodePassword);
	}
}