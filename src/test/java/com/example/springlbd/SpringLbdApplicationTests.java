package com.example.springlbd;

import com.example.springlbd.enity.employee.Employee;
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


    @Test
    void contextLoads() {
    }


}
