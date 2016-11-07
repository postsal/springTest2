package com.hujian.spring.aop.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hujian on 2016/10/23.
 */
@Aspect
@Component
public class LoggingAspect {
    //声明该方法是一个前置通知
    @Before("execution(public int com.hujian.spring.aop.impl.AtithmeticCalculator.*(int,int))")
    public void beforeMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        List<Object> args = Arrays.asList(point.getArgs());
        System.out.println("The method " + methodName + " begins" + args);
    }

    /**
     * 在方法执行之后执行，无论是否发生异常
     *
     * @param point
     */
    @After("execution(public int com.hujian.spring.aop.impl.AtithmeticCalculator.*(int,int))")
    public void afterMethod(JoinPoint point) {
        String methodName = point.getSignature().getName();
        System.out.println("The method " + methodName + " ends");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知可以访问到方法的返回值
     *
     * @param joinPoint
     */
    @AfterReturning(value = "execution(public int com.hujian.spring.aop.impl.AtithmeticCalculator.*(int,int))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();

        System.out.println("the method" + methodName + "ends with " + result);
    }

    /**
     * 在目标方法出现异常是执行的代码
     * 可以访问到异常的对象
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(public int com.hujian.spring.aop.impl.AtithmeticCalculator.*(int,int))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("the method" + methodName + "occurs excetion " + ex);
    }

    /**
     * 环绕通知需要携带着ProceedingJoinPoint 类型的参数
     * 类似于动态代理的全过程：ProceedingJoinPoint类型的参数决定是否执行目标方法
     * 而且环绕通知必须有返回值
     */
    @Around("execution(public int com.hujian.spring.aop.impl.AtithmeticCalculator.*(int,int))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        String methodName = joinPoint.getSignature().getName();
        //执行目标方法
        try {
            //前置通知
            System.out.println("the method" + methodName + "begins with " + Arrays.asList(joinPoint.getArgs()));
            result = joinPoint.proceed();
            //返回通知
            System.out.println("the method ends with" + result);
        } catch (Throwable e) {
            e.printStackTrace();
            //异常通知
            System.out.println("the method" + methodName + "occurs excetion " + e);
        }
        //后置通知
        System.out.println("the method" + methodName + " ends");
        return result;
    }
}
