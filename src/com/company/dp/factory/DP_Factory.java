package com.company.dp.factory;

abstract class Product {
    public void method1() {
        System.out.println("method1");
    }

    public abstract void method2();
}

class P1 extends Product {
    @Override
    public void method2() {
        System.out.println("p1 method2");
    }
}

class P2 extends Product {
    @Override
    public void method2() {
        System.out.println("p2 method2");
    }
}

abstract class Creator {
    public abstract <T extends Product> T createProduct(Class<T> c);
}


class C1 extends Creator {
    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {

        }
        return (T) product;
    }
}


public class DP_Factory {
    public static void main(String[] args) {
        Creator creator = new C1();
        Product product = creator.createProduct(P1.class);
    }
}
