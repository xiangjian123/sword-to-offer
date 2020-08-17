package com.company.dp;

import java.util.Vector;

abstract class Subject {
    private Vector<Observer> obs = new Vector<>();

    public void add(Observer o) {
        System.out.println("subject add observer " + o);
        obs.add(o);
    }

    public void delete(Observer o) {
        System.out.println("subject remote observer " + o);
        obs.remove(o);
    }

    public void notify1() {
        for (Observer o : obs) {
            o.update();
        }
    }
}

class Subject1 extends Subject {
    public void method() {
        super.notify1();
    }
}

interface Observer {
    void update();
}


class O1 implements Observer {
    @Override
    public void update() {
        System.out.println("subject is updated");
    }
}



public class DP_Observer {
    public static void main(String[] args) {
        Subject1 s = new Subject1();
        Observer o = new O1();
        s.add(o);
        s.method();
        s.delete(o);
        s.method();
    }
}
