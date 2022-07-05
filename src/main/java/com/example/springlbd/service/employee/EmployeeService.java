package com.example.springlbd.service.employee;

import com.example.springlbd.enity.employee.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public interface EmployeeService {


    List findAll();
    String GetEmployeeNickname(String firstName, String lastName);

    Employee findByName(String firstNameOrLastName);    //która wyszukuje pracownika po imieniu lub nazwisku (tzn. można podać
                                                        //imię lub nazwisko pracownika i powinniśmy otrzymać jego pełne dane).
    Employee save(Employee employee); //która zapiszę dane pracownika do mapy.

}
