package com.suresh.aspects;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

	private Logger logger = Logger.getLogger(LoggerAspect.class.getName());

	@Around("execution(* com.suresh.services.*.*(..))")
	public void log(ProceedingJoinPoint jp) throws Throwable {
		logger.info(jp.getSignature().toString() + " method execution start");
		Instant start = Instant.now();
		jp.proceed();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		logger.info("Time took to execute the method : " + timeElapsed);
		logger.info(jp.getSignature().toString() + " method execution end");
	}

}
