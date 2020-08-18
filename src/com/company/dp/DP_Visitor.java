package com.company.dp;


abstract class Element {
    abstract void doS();
    abstract void accept(IVisitor visitor);
}

class Element1 extends Element {
    @Override
    public void doS() {
        System.out.println("doS");
    }

    @Override
    public void accept(IVisitor visitor) {
        System.out.println("accept " + visitor);
    }
}

interface IVisitor {
    void visit(Element1 e1);
}

class Visitor implements IVisitor {
    @Override
    public void visit(Element1 e1) {
        System.out.println("visit " + e1);
    }
}

class ObjectStructure {
    public static Element createElement() {
        return new Element1();
    }
}

public class DP_Visitor {
    public static void main(String[] args) {
        Element e1 = ObjectStructure.createElement();
        e1.accept(new Visitor());
        e1.doS();
    }


}
