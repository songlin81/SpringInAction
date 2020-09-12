package com.example.demo.service.jwt;

import com.example.demo.entity.member.User;
import com.example.demo.repository.member.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserSecurityService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        if (user == null) {
            User mobileUser = userRepository.findByMobile(name);
            if (mobileUser == null) {
                User emailUser= userRepository.findByEmail(name);
                if(emailUser==null)
                {
                    throw new UsernameNotFoundException("email and mobile do not exist!");
                }
                else{
                    user=userRepository.findByEmail(name);
                }
            }
            else {
                user = userRepository.findByMobile(name);
            }
        }
        return user;
    }
}