package com.hujian.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hujian on 2016/10/22.
 */
public class Main {
    public static void main(String[] args){
        ApplicationContext ctx=new  ClassPathXmlApplicationContext("applicationContext.xml");

        AtithmeticCalculator atithmeticCalculator = (AtithmeticCalculator) ctx.getBean("atithmeticCalculatorImpl");

        int result=atithmeticCalculator.add(3,6);

        System.out.println("Result:"+result);
        int result1=atithmeticCalculator.div(12,3);

        System.out.println("Result:"+result1);
    }
}
