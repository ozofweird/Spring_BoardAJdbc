package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class Log {
	
	@Around("PointcutCommon.allPointcut()")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		// 메서드명 추출
		String method = pjp.getSignature().getName();
		
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();
		
		Object obj = pjp.proceed();
		
		stopwatch.stop();
		System.out.println(method + "() 메서드 수행에 걸린 시간 : "
				+ stopwatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}
	
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		// 메서드명 추출
		String method = jp.getSignature().getName();
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println(method + "() 메서드 예외 : 부적절한 값");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println(method + "() 메서드 예외 : 숫자 형식 값이 아닌 값");
		} else if(exceptObj instanceof Exception) {
			System.out.println(method + "() 메서드 예외 : 문제 발생");
		}
	}
}
