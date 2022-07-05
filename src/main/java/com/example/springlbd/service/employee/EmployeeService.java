package com.example.springlbd.service.employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List findAll();
    String GetEmployeeNickname(String firstName, String lastName);
}
