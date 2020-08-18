package com.company.dp.bridge;

public class I2 implements Implementor {
    @Override
    public void doSomething() {
        System.out.println("i2 do something");
    }

    @Override
    public void doAnything() {
        System.out.println("i2 do anything");
    }
}
