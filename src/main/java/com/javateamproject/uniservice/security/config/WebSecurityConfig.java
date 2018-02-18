package com.javateamproject.uniservice.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@ComponentScan("com.javateamproject.uniservice")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
              .antMatchers("/user/**").hasAuthority("USER")
              .antMatchers("/admin/**").hasAuthority("ADMIN")
              .antMatchers("/student/**").hasAuthority("STUDENT")
              .antMatchers("/lecturer/**").hasAuthority("LECTURER")
              .antMatchers("/cooperator/**").hasAuthority("COOPERATOR")
              .antMatchers("/css/**").permitAll()
              .antMatchers("/js/**").permitAll()
              .antMatchers("/fonts/**").permitAll()
              .antMatchers("/").permitAll()
              .anyRequest().authenticated()
            .and()
              .formLogin().loginPage("/login")
              .usernameParameter("login")
              .defaultSuccessUrl("/")
              .failureUrl("/login?error")
              .permitAll()
            .and()
              .logout()
              .logoutUrl("/logout")
              .deleteCookies("remember-me")
              .logoutSuccessUrl("/login")
              .permitAll()
            .and()
              .csrf()
              .disable();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
