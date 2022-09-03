package com.company;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyyMMdd HHmm"));

    public static void main(String[] args) throws Exception {
        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0 ; i < 5; i++) {
            Thread t = new Thread(example, "name-" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

    }

    @Override
    public void run() {
        System.out.println("thread name: " + Thread.currentThread().getName() + " default formatter = " + formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());

        System.out.println("thread name: " + Thread.currentThread().getName() + " current formatter = " + formatter.get().toPattern());

    }


}
