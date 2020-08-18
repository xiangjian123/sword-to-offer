package com.company.dp.bridge;

public class A1 extends Abstraction {
    public A1(Implementor imp) {
        super(imp);
    }

    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
