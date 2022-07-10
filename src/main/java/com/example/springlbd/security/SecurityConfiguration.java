package com.example.springlbd.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder encoder;

    public SecurityConfiguration(PasswordEncoder encoder) {
        this.encoder = encoder;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(encoder.encode("user"))
            .roles("USER")
                .and()
            .withUser("admin")
            .password(encoder.encode("admin"))
            .roles("ADMIN");
    }




}
