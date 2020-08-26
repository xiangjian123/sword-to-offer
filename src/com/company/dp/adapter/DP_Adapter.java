package com.company.dp.adapter;

interface Target {
    public void request();
}

class T1 implements Target {
    @Override
    public void request() {
        System.out.println("request t1");
    }
}

class Adaptee {
    public void do1() {
        System.out.println("adaptee do1");
    }
}

class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.do1();
    }
}

class Client {
    public static void main(String[] args) {
        Target target = new T1();
        target.request();
        Target target1 = new Adapter();
        target1.request();
    }
}

/**
 * 类适配器 单个对象，使用继承
 *
 *
 * 对象适配器 多个对象，用关联关系处理
 */
public class DP_Adapter {

}
