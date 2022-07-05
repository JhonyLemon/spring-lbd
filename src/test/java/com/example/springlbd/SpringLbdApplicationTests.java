package com.example.springlbd;

import com.example.springlbd.enity.employee.Employee;
import com.example.springlbd.service.employee.EmployeeService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;

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

    @Test
    void saveTest() {
        Employee employee = new Employee(
                "Adam",
                "Nosol",
                "34341243",
                "cbc222",
                "555555555"
        );
        Employee savedEmployee = employeeService.save(employee);
        AssertionsForClassTypes.assertThat(savedEmployee).isNotNull();

    }

    @Test
    void findByName() {
        for (Employee e :
                List.of(
                        new Employee(
                                "Adam",
                                "Nosol",
                                "34341243",
                                "cbc222",
                                "555555555"
                        ),
                        new Employee(
                                "Michał",
                                "Nosol",
                                "34341243",
                                "cbc222",
                                "555555555"
                        ),
                        new Employee(
                                "Kamil",
                                "Nosol",
                                "34341243",
                                "cbc222",
                                "555555555"
                        ),
                        new Employee(
                                "Nosol",
                                "Adam",
                                "34341243",
                                "cbc222",
                                "555555555"
                        ),
                        new Employee(
                                "Nosol",
                                "Nosol",
                                "34341243",
                                "cbc222",
                                "555555555"
                        )


                )) {
            employeeService.save(e);
        }

        Employee e=employeeService.findByName("Adam");
        AssertionsForClassTypes.assertThat(e.getId()).isEqualTo(1);
    }


}
