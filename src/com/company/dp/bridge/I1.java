package com.company.dp.bridge;

public class I1 implements Implementor {
    @Override
    public void doSomething() {
        System.out.println("i1 do something");
    }

    @Override
    public void doAnything() {
        System.out.println("i1 do anything");
    }
}
