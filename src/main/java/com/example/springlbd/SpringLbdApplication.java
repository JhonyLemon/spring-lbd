package com.example.springlbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringLbdApplication {


    private EmployeeService employeeService;

    public SpringLbdApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringLbdApplication.class, args);
    }

    @PostConstruct
    private void ExampleFindAllUsage(){
        employeeService.findAll();
    }

}
