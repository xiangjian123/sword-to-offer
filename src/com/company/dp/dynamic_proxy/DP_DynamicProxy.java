package com.company.dp.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;

interface Subject {
    public void do1(String str);
}

class S1 implements Subject {
    @Override
    public void do1(String str) {
        System.out.println("do1 " + str);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target = null;
    public MyInvocationHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}

interface IAdvice {
    public void exec();
}

class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println(" before advice");
    }
}

class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        if (true) {
            (new BeforeAdvice()).exec();
        }
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}

class Client {
    public static void main(String[] args) {
        Subject subject = new S1();
        InvocationHandler handler = new MyInvocationHandler(subject);

        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.do1("finish");
    }
}
public class DP_DynamicProxy {
}
