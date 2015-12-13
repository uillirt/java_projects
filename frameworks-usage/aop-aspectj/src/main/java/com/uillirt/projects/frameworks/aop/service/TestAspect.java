package com.uillirt.projects.frameworks.aop.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by kshekhovtsova on 13.12.2015.
 */
@Aspect
public class TestAspect {

    @Around("execution(* com.uillirt.projects.frameworks.aop.service.AopTestService.sleepMethod(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Aop: before executing");
        long startTime = System.nanoTime();
        Object result = pjp.proceed();
        long endTime = System.nanoTime();
        System.out.println("Aop: executed for (ms): " + (endTime - startTime)/1000000);
        return result;
    }
}
