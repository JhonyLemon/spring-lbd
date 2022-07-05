package com.example.springlbd.service.employee;

import com.example.springlbd.enity.employee.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class EmployeeServiceTwo implements EmployeeService {

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String GetEmployeeNickname(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findByName(String firstNameOrLastName) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }
}
