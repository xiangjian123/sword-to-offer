package com.company.dp.single;

import java.util.ArrayList;
import java.util.Random;

public class Singleton1 {
    private static final Singleton1 singleton = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getSingleton() {
        return singleton;
    }

    public static void doSomething() {}
}

// 有上限的多例模式
class Emperor {
    private static int max = 2;
    private static ArrayList<String> names = new ArrayList<>();
    private static ArrayList<Emperor> emperors = new ArrayList<>();
    private static int count = 0;
    static {
        for (int i = 0; i < max; i++) {
            emperors.add(new Emperor("emperor" + (i + 1)));
        }
    }
    private Emperor(){}
    private Emperor(String name) {
        names.add(name);
    }

    public static Emperor getInstance() {
        Random random = new Random();
        count = random.nextInt(max);
        return emperors.get(count);
    }

    public void say() {
        System.out.println(names.get(count));
    }
}

class Minister {
    public static void main(String[] args) {
        int min = 5;
        for (int i = 0; i < min; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("min " + i + " meet: " );
            emperor.say();
        }
    }
}