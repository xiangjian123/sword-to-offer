package com.company.dp.facade;


class F_C1 {
    public void method1() {
        System.out.println("facade class c1 method1");
    }
}

class F_C2 {
    public void method2() {
        System.out.println("facade class c2 method2");
    }
}

class F_C3 {
    public void method3() {
        System.out.println("facade class c3 method3");
    }
}

class Facade {
    F_C1 c1 = new F_C1();
    F_C2 c2 = new F_C2();
    F_C3 c3 = new F_C3();

    public void method1() {
        c1.method1();
    }

    public void method2() {
        c2.method2();
    }

    public void method3() {
        c3.method3();
    }
}

public class DP_Facade {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.method1();
        f.method2();
        f.method3();
    }
}
