package com.example.tliaswebmanageme.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
@Order(1)
public class AopAspect {
    @Pointcut("execution(* com.example.tliaswebmanageme.controller.*.*(..))")
    private void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        log.info("before");
    }

    @Around("execution(* com.example.tliaswebmanageme.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around_before");
        Object proceed = joinPoint.proceed();

        log.info("around_after");
        return proceed;
    }

    @After("execution(* com.example.tliaswebmanageme.controller.*.*(..))")
    public void after() {
        log.info("after");
    }

    @AfterReturning("execution(* com.example.tliaswebmanageme.controller.*.*(..))")
    public void afterReturning() {
        log.info("afterReturning");
    }

    @AfterThrowing("execution(* com.example.tliaswebmanageme.controller.*.*(..))")
    public void afterThrowing() {
        log.info("afterThrowing");
    }
}

