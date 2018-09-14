package com.belle.springsecurityjwt.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ControllerAspeect {
    @Pointcut("execution(public * com.belle.springsecurityjwt.controller.*.*(..))")
    public void weblog(){}

    @Before ("weblog()")
    public void deBefore(JoinPoint joinPoint)throws Exception{
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes ();
        HttpServletRequest request=attributes.getRequest ();
        log.info ("URL:"+request.getRequestURL ().toString ());
        log.info ("Http_METHOD:"+request.getMethod ());
        log.info ("IP:"+request.getRemoteAddr ());
        log.info ("CLASS_METHOD:"+joinPoint.getSignature ().getDeclaringTypeName ()+"."+joinPoint.getSignature ().getName ());
        log.info ("ARGS:"+ Arrays.toString (joinPoint.getArgs ()));
    }

   /* @AfterReturning(returning="ret",pointcut="weblog()")
    public void doAfterReturning(Object ret) throws Exception{
        //处理完请求，返回内容
        log.info ("方法返回值："+ret);
    }

    @AfterThrowing("weblog()")
    public void throwss(JoinPoint jp){
        log.info ("方法异常时执行");
    }

    @After ("weblog()")
    public void after(JoinPoint jp){
        log.info ("方法最后执行");
    }*/

    @Around ("weblog()")
    public Object arround(ProceedingJoinPoint pjp){
        //log.info ("方法环绕start");
        long timeBefore=System.currentTimeMillis ();
        try {
            Object o=pjp.proceed ();
            //log.info ("方法环绕proceed，结果是："+o);
            log.info ("接口执行时间："+(System.currentTimeMillis ()-timeBefore)+"ms");
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace ();
            return null;
        }
    }
}
