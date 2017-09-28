package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {
    private  final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.demo.controller.GoodsController.*(..))")
    public  void log(){
    }

    /**
     * 日志拦截器（拦截所有方法）
     */
    @Before("log()")
    public  void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
       HttpServletRequest request = attributes.getRequest();
        // utl
        logger.info("url={}",request.getRequestURL());
        // method
        logger.info("method={}",request.getMethod());
        // ip
        logger.info("ip={}",request.getRemoteAddr());
        // 类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        logger.info("args={}",joinPoint.getArgs());

        logger.info("触发方法");
        System.out.print("前置镇江");
    }

    @After("log()")
    public  void  doAfter(){
        logger.info("跳出方法");
        System.out.print("后置振强");
    }
}
