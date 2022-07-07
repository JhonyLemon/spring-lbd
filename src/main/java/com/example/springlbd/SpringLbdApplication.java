package com.example.springlbd;

import com.example.springlbd.entity.sprint.Sprint;
import com.example.springlbd.entity.sprint.Status;
import com.example.springlbd.entity.userstory.UserStory;
import com.example.springlbd.services.sprint.SprintService;
import com.example.springlbd.services.userstory.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
public class SpringLbdApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLbdApplication.class, args);
    }



}
