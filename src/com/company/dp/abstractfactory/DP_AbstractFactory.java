package com.company.dp.abstractfactory;

abstract class APA {
    public void shareMethod() {}

    public abstract void do1();
}

class PA1 extends APA {
    @Override
    public void do1() {
        System.out.println("product a1");
    }
}

class PA2 extends APA {
    @Override
    public void do1() {
        System.out.println("product a2");
    }
}

abstract class APB {
    public void shareMethod() {}

    public abstract void do1();
}

class PB1 extends APB {
    @Override
    public void do1() {
        System.out.println("product b1");
    }
}

class PB2 extends APB {
    @Override
    public void do1() {
        System.out.println("product b2");
    }
}

abstract class ACreator {
    public abstract APA createPA();
    public abstract APB createPB();
}

class C1 extends ACreator {
    @Override
    public APA createPA() {
        return new PA1();
    }

    @Override
    public APB createPB() {
        return new PB1();
    }
}

class C2 extends ACreator {
    @Override
    public APA createPA() {
        return new PA2();
    }

    @Override
    public APB createPB() {
        return new PB2();
    }
}

public class DP_AbstractFactory {
    public static void main(String[] args) {
        ACreator c1 = new C1();
        ACreator c2 = new C2();

        APA a1 = c1.createPA();
        APB b1 = c1.createPB();

        APA a2 = c2.createPA();
        APB b2 = c2.createPB();

        a1.do1();
        b1.do1();
        a2.do1();
        b2.do1();
    }
}
