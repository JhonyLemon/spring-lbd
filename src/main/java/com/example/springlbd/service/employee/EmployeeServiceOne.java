package com.example.springlbd.service.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class EmployeeServiceOne implements EmployeeService {


    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceOne.class);
    @Value("${prefix}")
    String prefix;
    @Value("${sufix}")
    String sufix;

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public String GetEmployeeNickname(String firstName, String lastName) {
        LOG.info("firstNmae: "+firstName);
        LOG.info("lastName: "+lastName);
        String nickname=null;
        nickname = prefix+firstName.substring(0,(firstName.length()<3 ? firstName.length() : 3))+sufix+ lastName.substring(0,(lastName.length()<3 ? lastName.length() : 3));
        LOG.info("nickname: "+nickname);
        return nickname;
    }
}
