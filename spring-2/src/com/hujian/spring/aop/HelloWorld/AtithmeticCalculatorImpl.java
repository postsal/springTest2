package com.hujian.spring.aop.HelloWorld;

/**
 * Created by hujian on 2016/10/11.
 */
public class AtithmeticCalculatorImpl implements AtithmeticCalculator{

    @Override
    public int add(int i, int j) {
//        System.out.println("The method add begins with["+i+","+j+"]");
        int result=i+j;
//        System.out.println("The method add ends with"+ result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
//        System.out.println("The method sub begins with["+i+","+j+"]");
        int result=i-j;
//        System.out.println("The method sub ends with"+ result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
//        System.out.println("The method mul begins with["+i+","+j+"]");
        int result=i*j;
//        System.out.println("The method mul ends with"+ result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("The method div begins with["+i+","+j+"]");
        int result=i/j;
        System.out.println("The method div ends with"+ result);
        return result;
    }
}
