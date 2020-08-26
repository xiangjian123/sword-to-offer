package com.company.dp.observer;

import java.util.Vector;

// 被观察者。动态增加。取消观察者。一般时抽象类或者实习类。管理观察者并通知观察者。
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

// 具体的被观察者。定义自身的业务逻辑，定义对哪些时间进行通知。
class Subject1 extends Subject {
    public void method() {
        super.notify1();
    }
}


// 观察者。接收到消息后，进行update操作，对接受到的信息进行处理
interface Observer {
    void update();
}

// 具体的观察者。各个观察者有自己的处理逻辑。
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
