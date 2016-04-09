package com.dzhao.exams.security.basic.services;

import com.dzhao.exams.security.basic.model.MyUser;
import com.dzhao.exams.security.basic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

/**
 * Created by dzhao on 14/03/2016.
 */
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser myUser = userRepository.findByEmail(s);
        return null;
    }
}
