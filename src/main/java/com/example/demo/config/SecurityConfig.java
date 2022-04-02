package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String READ = "read";
    public static final String WRITE = "write";
    public static final String PASSWORD = "{noop}password";
    public static final String IVAN = "Ivan";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser(IVAN).password(PASSWORD).authorities(READ);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .and()
                .authorizeRequests().antMatchers("/persons").permitAll()
                .and()
                .authorizeRequests().antMatchers("/persons/all").hasAnyAuthority(READ)
                .and()
                .authorizeRequests().antMatchers("/persons/by-city").hasAnyAuthority(READ)
                .and()
                .authorizeRequests().antMatchers("/persons/by-age-less").hasAnyAuthority(READ)
                .and()
                .authorizeRequests().antMatchers("/persons/by-name-surname").hasAnyAuthority(READ)
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }

}
