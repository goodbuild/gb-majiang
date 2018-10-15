package com.goodbuild.majiang.config;

import com.goodbuild.majiang.domain.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 16:19
 * @Description:
 * @Version: 1.0.0
 */
@Aspect
@Configuration
public class AopConfig {

    @Around("execution(public com.goodbuild.majiang.domain.ResultBean *(..))")
    public ResultBean<?> invoke(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return (ResultBean<?>) pjp.proceed();
        } catch (Exception e) {
            return exceptionHandle(pjp, e);
        }
    }

    private ResultBean<?> exceptionHandle(ProceedingJoinPoint pjp, Exception e) {
       ResultBean bean = new ResultBean(e);
       return bean;
    }
}
