package com.company.dp.visitor;


import java.util.Random;

// 抽象元素。声明接受哪一类访问者的访问。程序上通过accept参数定义
abstract class Element {
    abstract void doS();
    abstract void accept(Visitor visitor);
}

// 具体元素。实现accept方式，通常是 visitor.visit(this)
class ConcreteElement1 extends Element {
    @Override
    public void doS() {
        System.out.println("concrete element1 do itself thing");
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("element1 accept visitor: " + visitor);
    }
}

class ConcreteElement2 extends Element {
    @Override
    public void doS() {
        System.out.println("concrete element2 do itself thing");
    }

    @Override
    public void accept(Visitor visitor) {
        System.out.println("element2 accept visitor: " + visitor);
    }
}

// 抽象访问者。声明访问者可以访问哪些元素。visit方法的参数定义哪些对象是可以被访问的。
interface IVisitor {
    void visit(ConcreteElement1 e1);
    void visit(ConcreteElement2 e2);
}

// 具体的访问者。
class Visitor implements IVisitor {
    @Override
    public void visit(ConcreteElement1 e1) {
        System.out.println("visit " + e1);
        e1.doS();
    }

    @Override
    public void visit(ConcreteElement2 e2) {
        System.out.println("visit " + e2);
        e2.doS();
    }
}

// 结构对象。元素产生者。一般容纳在多个不同类，接口的容器。如List set map。
class ObjectStructure {
    public static Element createElement() {
        Random rand = new Random();
        if (rand.nextInt(100) > 50) {
            return new ConcreteElement1();
        } else {
            return new ConcreteElement2();
        }
    }
}

/**
 * 封装一些作用于某种数据结构中的各元素的操作，
 * 它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
 *
 */
public class DP_Visitor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Element e1 = ObjectStructure.createElement();
            e1.accept(new Visitor());
            e1.doS();
        }
    }
}
