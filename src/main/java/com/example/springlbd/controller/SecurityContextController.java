package com.example.springlbd.controller;

import com.example.springlbd.dto.UserAndRolesDto;
import com.example.springlbd.services.SecurityContextService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/security")
@AllArgsConstructor
public class SecurityContextController {

    private final SecurityContextService securityContextService;

    @GetMapping("/info")
    public UserAndRolesDto getCurrentlyLogged(){
        return securityContextService.getCurrentlyLogged();
    }


}
