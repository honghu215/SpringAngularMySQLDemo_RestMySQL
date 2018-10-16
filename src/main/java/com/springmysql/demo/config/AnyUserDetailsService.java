package com.springmysql.demo.config;

import com.springmysql.demo.model.UserEntity;
import com.springmysql.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userService.getByName(username);
        if(user == null)
            throw new UsernameNotFoundException("UserEntity doesn't exist!");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(user.getRole());
        return new User(user.getName(), user.getPassword(), simpleGrantedAuthorities);
    }

    /*
     * Authorities string conversion
     * eg. "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     * @param roleStr
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr) {
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for(String role : roles){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }
}
