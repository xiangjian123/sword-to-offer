package com.company.dp.abstractfactory;

public class FemaleFactory implements HumanFactory {
    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }
}
