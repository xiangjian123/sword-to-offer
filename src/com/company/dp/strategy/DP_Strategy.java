package com.company.dp.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

interface IStrategy {
    void operate();
}

class BackDoor implements IStrategy {
    @Override
    public void operate() {
        System.out.println("open back door");
    }
}

class GreenLight implements IStrategy {
    @Override
    public void operate() {
        System.out.println("open green light");
    }
}

class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("block enemy");
    }
}

class Context {
    private IStrategy strategy;
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        this.strategy.operate();
    }
}

class ZhaoYun {
    public static void main(String[] args) {
        Context context;
        context = new Context(new BackDoor());
        context.operate();

        context = new Context(new GreenLight());
        context.operate();

        context = new Context(new BackDoor());
        context.operate();
    }
}

/**
 * 使用策略枚举，实现加法减法和其它扩展
 */

enum Calculator {
    ADD("+") {
        @Override
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        @Override
        public int exec(int a, int b) {
            return a - b;
        }
    };
    String value = "";
    private Calculator(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);

}

/**
 * 定义一组算法，将算法都封装起来，并且可以互换
 * 使用面向对象的继承和多态机制
 */
public class DP_Strategy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        String sym = in.next();
        int b = in.nextInt();
        System.out.println("input params: " + Arrays.toString(args));
        System.out.println("result: " + a + sym + b + " = " + Calculator.ADD.exec(a, b));
    }
}
