package com.mzk.springsecuritydemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * ApiLogAspect
 *
 * @author miaozhenkai
 * @version 2019-07-30 18:46
 */
@Slf4j
@Aspect
@Component
public class ApiLogAspect {

    /**
     * 定义日志切入点
     */
    @Pointcut("execution(public * com.mzk.springsecuritydemo.controller.*.*(..))")
    public void logCut() {
    }

    /**
     * 在切入点开始处切入内容
     *
     * @param joinPoint
     */
    @Before("logCut()")
    public void logBefore(JoinPoint joinPoint) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();
        log.info("session:{}", request.getSession().getId());

    }

    /**
     * 在切入点return内容之后切入内容
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "logCut()")
    public void logAfterReturning(Object object) {


    }
}
