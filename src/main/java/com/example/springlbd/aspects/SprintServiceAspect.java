package com.example.springlbd.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SprintServiceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SprintServiceAspect.class);

}
