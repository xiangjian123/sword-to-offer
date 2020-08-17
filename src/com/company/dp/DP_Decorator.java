package com.company.dp;


abstract class AbstractComponent {
    public void operator() {
    }
}

class Component extends AbstractComponent {
    @Override
    public void operator() {
        System.out.println("Operator");
    }
}

abstract class AbstractDecorator extends AbstractComponent {
    private AbstractComponent abstractComponent = null;

    public AbstractDecorator(AbstractComponent abstractComponent) {
        this.abstractComponent = abstractComponent;
    }

    @Override
    public void operator() {
        this.abstractComponent.operator();
    }
}

class C1 extends AbstractDecorator {
    public C1(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void operator() {
        this.method1();
        super.operator();
    }
}

class C2 extends AbstractDecorator {
    public C2(AbstractComponent abstractComponent) {
        super(abstractComponent);
    }

    public void method2() {
        System.out.println("method2");
    }

    @Override
    public void operator() {
        this.method2();
        super.operator();
    }
}


public class DP_Decorator {
    public static void main(String[] args) {
        AbstractComponent c = new Component();
        c = new C1(c);
        c = new C2(c);
        c.operator();
    }
}
