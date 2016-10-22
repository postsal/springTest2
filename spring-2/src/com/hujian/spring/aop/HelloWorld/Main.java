package com.hujian.spring.aop.HelloWorld;

/**
 * Created by hujian on 2016/10/11.
 */
public class Main {
    public static void main(String[] args) {
//        AtithmeticCalculator atithmeticCalculator = null;
//        atithmeticCalculator = new AtithmeticCalculatorImpl();
        AtithmeticCalculator target=new AtithmeticCalculatorImpl();
        AtithmeticCalculator proxy= (AtithmeticCalculator) new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();

        System.out.println(proxy.getClass().getName());
        int result = proxy.add(4, 2);
        System.out.println("--->"+result);
//        atithmeticCalculator.sub(4, 2);
//        atithmeticCalculator.mul(4, 2);
//        atithmeticCalculator.div(4, 2);
    }
}
