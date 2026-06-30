package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.BookService.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("[AOP Trigger] Before Advice: Method execution starting...");
    }

    @After("execution(* com.library.service.BookService.*(..))")
    public void logAfterMethodExecution() {
        System.out.println("[AOP Trigger] After Advice: Method execution finalized.");
    }

    @Around("execution(* com.library.service.BookService.*(..))")
    public Object logPerformanceMetrics(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTimestamp = System.currentTimeMillis();
        Object outputValue = joinPoint.proceed();
        long latencyDuration = System.currentTimeMillis() - startTimestamp;
        System.out.println("[AOP Performance Trace] " + joinPoint.getSignature().getName() + " executed in " + latencyDuration + "ms");
        return outputValue;
    }
}