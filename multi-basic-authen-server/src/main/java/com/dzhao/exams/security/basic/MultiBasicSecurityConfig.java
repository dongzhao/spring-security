package com.dzhao.exams.security.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * Created by dzhao on 14/03/2016.
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, proxyTargetClass = true)
public class MultiBasicSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin123").roles("ADMIN")
                .and()
                .withUser("user").password("user123").roles("USER");
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig1 extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().anonymous().disable();
            http.httpBasic().and().authorizeRequests()
                    .antMatchers("/api/admin", "/api/admin/**").hasAnyRole("ADMIN").anyRequest().authenticated();
        }
    }

    @Configuration
    @Order(2)
    public static class ApiWebSecurityConfig2 extends WebSecurityConfigurerAdapter{
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().anonymous().disable();
            http.httpBasic().and().authorizeRequests()
                    .antMatchers("/api/user", "/api/user/**").hasAnyRole("USER", "ADMIN").anyRequest().authenticated();

        }
    }
}
