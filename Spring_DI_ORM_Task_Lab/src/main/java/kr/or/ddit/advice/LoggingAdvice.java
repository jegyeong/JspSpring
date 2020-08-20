package kr.or.ddit.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
		String clzName = joinpoint.getTarget().getClass().getSimpleName();
		Signature signature = joinpoint.getSignature();
		String methodName = signature.getName();
		Object[] args = joinpoint.getArgs();
		
		logger.info("{}.{} 호출, 전달 파라미터 : {}", clzName, methodName, Arrays.toString(args));
		long startTime = System.currentTimeMillis();
		Object retValue = joinpoint.proceed(args);
		long endTime = System.currentTimeMillis();
		logger.info("{}.{} 호출 종료[{}ms], 반환값 : {}", clzName, methodName, (endTime-startTime),retValue);
		return retValue;
	}
	
	public void before() {
		logger.info("핵심 관심사(target) 호출");
	}
}
