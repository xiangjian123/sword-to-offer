package com.company.dp;

interface Strategy {
    void st();
}

class S1 implements Strategy {
    @Override
    public void st() {
        System.out.println("s1");
    }
}

class S2 implements Strategy {
    @Override
    public void st() {
        System.out.println("s2");
    }
}

class Context {
    private Strategy s = null;
    public Context(Strategy _s) {
        this.s = _s;
    }

    public void st() {
        this.s.st();
    }
}

public class DP_Strategy {
    public static void main(String[] args) {
        Strategy s = new S1();
        Context c = new Context(s);
        c.st();
        c = new Context(new S2());
        c.st();
    }
}
