package com.example.demo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/addPerson").hasRole("ADMIN")
                .antMatchers("/index", "/personList", "/hello").hasRole("USER")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
    	PasswordEncoder encoder =
    		     PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
        UserDetails user =
             User.withUsername("user@test.fr")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        
        UserDetails admin =
                User.withUsername("admin@test.fr")
                   .password(encoder.encode("admin"))
                   .roles("ADMIN", "USER")
                   .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
