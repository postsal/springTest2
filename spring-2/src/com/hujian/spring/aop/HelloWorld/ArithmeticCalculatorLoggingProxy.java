package com.hujian.spring.aop.HelloWorld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by hujian on 2016/10/11.
 */
public class ArithmeticCalculatorLoggingProxy {

    //要代理的对象
    private AtithmeticCalculatorImpl target;

    public ArithmeticCalculatorLoggingProxy(AtithmeticCalculator target) {
        this.target= (AtithmeticCalculatorImpl) target;
    }

    public Object getLoggingProxy(){
        Object proxy=null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader=target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces=new Class[] {AtithmeticCalculator.class};
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h=new InvocationHandler() {
            /**
             * ]
             * @param proxy:正在返回的代理对象，一般情况下，在Invoke中都不使用该对象
             * @param method:正在被调用的方法
             * @param args:调用方法时传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName=method.getName();
                //日志
                System.out.println("The method"+methodName+"begins with"+ Arrays.asList(args));
                //执行方法
                Object result=method.invoke(target,args);
                //日志
                System.out.println("The method"+methodName+"ends with"+result);
                System.out.println("Invoke");
                return result;
            }
        };
        proxy=Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
