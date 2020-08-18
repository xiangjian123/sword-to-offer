package com.company.dp.factory;

public class NvWa {
    public static void main(String[] args) {
        AbstractFactory lu = new HumanFactory();
        Human white = lu.createHuman(WhiteHuman.class);
        white.getColor();
        white.talk();

        Human black = lu.createHuman(BlackHuman.class);
        black.getColor();
        black.talk();

        Human yellow = lu.createHuman(YellowHuman.class);
        yellow.getColor();
        yellow.talk();
    }
}
