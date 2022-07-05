package com.example.springlbd;

import com.example.springlbd.service.employee.EmployeeService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringLbdApplicationTests {


    @Autowired
    EmployeeService employeeService;

    @Value("${prefix}")
    String prefix;
    @Value("${sufix}")
    String sufix;


    @Test
    void contextLoads() {
    }

    @Test
    void GetEmployeeNickname() {
        String nickname=employeeService.GetEmployeeNickname("Adam","Nosol");
        AssertionsForClassTypes.assertThat(nickname).isEqualTo(prefix+"Ada"+sufix+"Nos");
        nickname=employeeService.GetEmployeeNickname("Ad","No");
        AssertionsForClassTypes.assertThat(nickname).isEqualTo(prefix+"Ad"+sufix+"No");

    }


}
