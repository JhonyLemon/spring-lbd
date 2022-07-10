package com.example.springlbd.services;

import com.example.springlbd.dto.UserAndRolesDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SecurityContextService {

    public UserAndRolesDto getCurrentlyLogged(){
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return new UserAndRolesDto(authentication.getName(),authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet()));
    }

}
