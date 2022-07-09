package com.example.springlbd.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserStoryAspect {

    private static final Logger LOG = LoggerFactory.getLogger(UserStoryAspect.class);

}
