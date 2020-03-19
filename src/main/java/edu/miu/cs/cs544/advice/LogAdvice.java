package edu.miu.cs.cs544.advice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class LogAdvice {

	@Autowired
	Logger logger;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@After("execution(* edu.miu.cs.cs544.*.*.*(..))")
	public void log(JoinPoint joinpoint) {
		
		Date date = new Date();
		logger.info(date+" Func Name ="+joinpoint.getSignature().getName()+" Class Name= "+joinpoint
				.getSignature().getClass().getName());

	}

}
