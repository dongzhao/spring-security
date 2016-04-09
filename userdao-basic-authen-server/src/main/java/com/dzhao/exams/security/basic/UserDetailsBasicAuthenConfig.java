package com.dzhao.exams.security.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by dzhao on 8/03/2016.
 */
@Configuration
@EnableWebSecurity
public class UserDetailsBasicAuthenConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().anonymous().disable();
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/rest/admin", "/rest/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/rest/user", "/rest/user/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin123").roles("ADMIN")
                .and()
                .withUser("user").password("user123").roles("USER");
    }
}
