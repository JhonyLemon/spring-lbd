package com.example.springlbd.service.employee;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("es2")
public class EmployeeServiceTwo implements EmployeeService {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String GetEmployeeNickname(String firstName, String lastName) {
        return null;
    }
}
