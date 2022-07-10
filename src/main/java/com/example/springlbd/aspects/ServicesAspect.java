package com.example.springlbd.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServicesAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ServicesAspect.class);

    @Around("execution(* com.example.springlbd.services..*.*(..))")
    public Object aroundServicesMethods(ProceedingJoinPoint joinPoint){
        Object val = joinPoint.getArgs();



        LOG.info("Starting method "+joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName()+" with "+String.valueOf(joinPoint.getArgs().length)+" arguments:");
        for (Object arg : joinPoint.getArgs()) {
            LOG.info(arg.getClass().getName()+": "+arg);
        }
        try{
            val=joinPoint.proceed();
            LOG.info("Successfully executed method and returned:");
            LOG.info(val.getClass().getName()+":");
            LOG.info(val.toString());
        }catch (Throwable e){
            LOG.info("Error while executing method "+joinPoint.getSignature().getDeclaringTypeName()+joinPoint.getSignature().getName());
        }
        return val;
    }

}
