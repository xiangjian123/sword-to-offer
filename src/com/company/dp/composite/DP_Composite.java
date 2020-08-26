package com.company.dp.composite;

import java.lang.reflect.Array;
import java.util.ArrayList;

abstract class Component {
    public void getInfo() {}
}

class Leaf extends Component {
    @Override
    public void getInfo() {
        System.out.println(this + " Leaf get info");
    }
}

class Composite extends Component {
    private ArrayList<Component> list = new ArrayList<>();

    public void add(Component component) {
        this.list.add(component);
    }
    public void remote(Component component) {
        this.list.remove(component);
    }
    public ArrayList<Component> getChildren() {
        return this.list;
    }

    @Override
    public void getInfo() {
        System.out.println(this + " Composite get info");
    }
}

class Client {
    public static void main(String[] args) {
        Composite root = new Composite();
        root.getInfo();

        Composite branch = new Composite();
        Leaf leaf = new Leaf();

        root.add(branch);
        branch.add(leaf);

        display(root);
    }

    public static void display(Composite root) {
        for (Component component : root.getChildren()) {
            if (component instanceof Leaf) {
                component.getInfo();
            } else {
                component.getInfo();
                display((Composite) component);
            }
        }
    }
}

/**
 * 将对象组合成树形结构以表示“部分-整体”的层次结构，使得用户对单个对象和组合对象的使用具有一致性
 *
 */
public class DP_Composite {

}
