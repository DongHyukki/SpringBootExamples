package com.example.kdh.donghyukkispringboot.sample.aop.springaop;

import com.example.kdh.donghyukkispringboot.sample.aop.aspectj.LoggingAspect;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDecorator implements MethodInterceptor {

    Logger logger = LoggerFactory.getLogger(LoggingDecorator.class);

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        logger.info("Redis Service Start");
        Object retVal = invocation.proceed();
        logger.info("Redis Service End");
        return retVal;
    }
}
