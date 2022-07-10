package com.example.springlbd.dto;

import java.util.Set;

public class UserAndRolesDto {

    private String name;
    private Set<String> roles;

    public UserAndRolesDto(String name, Set<String> roles) {
        this.name = name;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
