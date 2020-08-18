package com.company.dp.template;

abstract class HummerModel {
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    public final void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    // Hook method
    protected boolean isAlarm() {
        return true;
    }
}

class H1 extends HummerModel {
    private boolean flag = true;

    @Override
    protected void alarm() {
        System.out.println("H1 alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H1 engineboom");
    }

    @Override
    protected void start() {
        System.out.println("H1 start");
    }

    @Override
    protected void stop() {
        System.out.println("H1 stop");
    }

    @Override
    protected boolean isAlarm() {
        return this.flag;
    }

    public void setAlarm(boolean isAlarm) {
        this.flag = isAlarm;
    }
}

class H2 extends HummerModel {
    @Override
    protected void alarm() {
        System.out.println("H2 alarm");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H2 engineboom");
    }

    @Override
    protected void start() {
        System.out.println("H2 start");
    }

    @Override
    protected void stop() {
        System.out.println("H2 stop");
    }

    @Override
    protected boolean isAlarm() {
        return false;
    }
}

public class DP_Template {
    public static void main(String[] args) {
        H1 h1 = new H1();
        h1.setAlarm(true);
        h1.run();

        h1.setAlarm(false);
        h1.run();

        H2 h2 = new H2();
        h2.run();
    }
}
