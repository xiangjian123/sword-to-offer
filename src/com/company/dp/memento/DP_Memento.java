package com.company.dp.memento;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

class Originator {
    private String s;
    public String getState() {
        return s;
    }

    public void setState(String _s) {
        this.s = _s;
    }

    public Memento createMemento() {
        return new Memento(this.s);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }

}

class MementoManager {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class Memento {
    private String state = "";
    public Memento(String s) {
        this.state = s;
    }

    public String getState() {
        return state;
    }

    public void setState(String s) {
        this.state = s;
    }
}


public class DP_Memento {
    public static void main(String[] args) {
        Originator o1 = new Originator();
        MementoManager m1 = new MementoManager();

        o1.setState("Nice");
        m1.setMemento(o1.createMemento());

        System.out.println(o1.getState());

        o1.setState("Bad");
        System.out.println(o1.getState());

        o1.restoreMemento(m1.getMemento());
        System.out.println(o1.getState());
    }
}


// 扩展 带Clone的备忘录模式

class Origin_Clone implements Cloneable {
    private Origin_Clone backup;
    private String s;
    public String getState() {
        return s;
    }
    public void setState(String _s) {
        this.s = _s;
    }
    public void createMemento() {
        this.backup = this.clone();
    }
    public void restoreMemento() {
        this.setState(this.backup.getState());
    }
    @Override
    protected Origin_Clone clone() {
        try {
            return (Origin_Clone) super.clone();
        }catch (CloneNotSupportedException e) {
        }
        return null;
    }
}

class Mem_Clone {
    public static void main(String[] args) {
        Origin_Clone origin_clone = new Origin_Clone();
        origin_clone.setState("Good");
        System.out.println(origin_clone.getState());

        origin_clone.createMemento();

        origin_clone.setState("Bad");
        System.out.println(origin_clone.getState());

        origin_clone.restoreMemento();
        System.out.println(origin_clone.getState());

    }
}

// 多状态的备忘录

// 多备份的备忘录 Check point

