package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class FirstAspect {

    @Pointcut("execution(void com.example.App.logEvent(..))")
    private void allLogEventsMethods(){ }

    @Before("allLogEventsMethods()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("I'm from aspect");
    }
}
