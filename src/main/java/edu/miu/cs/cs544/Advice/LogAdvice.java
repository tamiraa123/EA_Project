package edu.miu.cs.cs544.Advice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LogAdvice {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @After("execution(* edu.miu.cs.cs544.controller.*.*(..))")
    public void log(JoinPoint joinpoint) {
        Date date = new Date();
        System.out.println(date+" Func Name ="+joinpoint.getSignature().getName()+" Class Name= "+joinpoint
                .getSignature().getClass().getName());
    }
}
