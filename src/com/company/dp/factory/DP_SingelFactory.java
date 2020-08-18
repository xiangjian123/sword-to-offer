package com.company.dp.factory;

import java.lang.reflect.Constructor;

class Singleton {
    private Singleton(){}

    public void do1() {}
}

class SingletonFactory {
    private static Singleton singleton;
    static {
        try {
            Class cl = Class.forName(Singleton.class.getName());
            Constructor constructor = cl.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {

        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}

public class DP_SingelFactory {

}
