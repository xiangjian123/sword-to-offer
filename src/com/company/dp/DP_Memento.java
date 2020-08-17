package com.company.dp;

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

    public void restartMemento(Memento memento) {
        this.setState(memento.getState());
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

    }
}
