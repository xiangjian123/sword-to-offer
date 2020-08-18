package com.company.dp.template;

abstract class HummerModel {
    public abstract void start();
    public abstract void stop();
    public abstract void alarm();
    public abstract void engineBoom();
    public final void run() {
            this.start();
            this.engineBoom();
            this.alarm();
            this.stop();
    }
}

class H1 extends HummerModel {
    @Override
    public void alarm() {
        System.out.println("H1 alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("H1 engineboom");
    }

    @Override
    public void start() {
        System.out.println("H1 start");
    }

    @Override
    public void stop() {
        System.out.println("H1 stop");
    }
}

class H2 extends HummerModel {
    @Override
    public void alarm() {
        System.out.println("H2 alarm");
    }

    @Override
    public void engineBoom() {
        System.out.println("H2 engineboom");
    }

    @Override
    public void start() {
        System.out.println("H2 start");
    }

    @Override
    public void stop() {
        System.out.println("H2 stop");
    }
}

public class DP_Template {
    public static void main(String[] args) {
        HummerModel h1 = new H1();
        h1.run();
    }
}
