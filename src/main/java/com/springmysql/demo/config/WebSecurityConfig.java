package com.springmysql.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AnyUserDetailsService anyUserDetailsService;

    @Autowired
    public void setAnyUserDetailsService(AnyUserDetailsService anyUserDetailsService) {
        this.anyUserDetailsService = anyUserDetailsService;
    }

    /*
     * Match "/" path, can access without authority
     * Match "/user" and all subpath, need "USER" authority
     * Enable CSRF
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api").permitAll()
                .antMatchers("/api/user/**").hasRole("USER");
    }

    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService((anyUserDetailsService));
    }
}
