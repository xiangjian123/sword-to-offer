package com.company.dp.factory;

abstract class AbstractFactory1 {
    public abstract Human createHuman();
}

class YellowFactory extends AbstractFactory1 {
    @Override
    public Human createHuman() {
        return new YellowHuman();
    }
}


public class DP_MultiFactory {
    public static void main(String[] args) {
        Human yellow = (new YellowFactory()).createHuman();
        yellow.getColor();
        yellow.talk();
    }
}
