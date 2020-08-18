package com.company.dp.abstractfactory;

public class NvWa {
    public static void main(String[] args) {
        HumanFactory female = new FemaleFactory();
        Human femaleBlack = female.createBlackHuman();
        femaleBlack.getColor();
        femaleBlack.talk();
        femaleBlack.getSex();
    }
}
