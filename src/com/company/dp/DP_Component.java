package com.company.dp;

import java.util.ArrayList;
import java.util.List;

abstract class Component1 {
    public void method() {
    }
}

class Composite extends Component1 {
    private ArrayList<Component1> cal = new ArrayList<>();

    public void add(Component1 c) {
        this.cal.add(c);
    }

    public void remote(Component1 c) {
        this.cal.remove(c);
    }

    ArrayList<Component1> getChild() {
        return this.cal;
    }
}

class Leaf extends Component1 {
    @Override
    public void method() {
        System.out.println("this is a leaf");
    }
}

public class DP_Component {
    public static void main(String[] args) {
        Composite root = new Composite();
        root.method();

        Composite branch = new Composite();
        Leaf leaf = new Leaf();

        root.add(branch);
        branch.add(leaf);

        display(root);

    }

    public static void display(Composite root) {
        for (Component1 component1 : root.getChild()) {
            if (component1 instanceof Leaf) {
                component1.method();
            } else {
                display((Composite) component1);
            }
        }
    }
}
