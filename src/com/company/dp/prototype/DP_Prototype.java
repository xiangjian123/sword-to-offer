package com.company.dp.prototype;


// 不通过new产生一个对象，而通过复制来死显得模型叫做原型模式

class Prototype implements Cloneable {
    @Override
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return prototype;
    }
}

// 深拷贝 浅拷贝
// 深拷贝需要实现对 可变类的成员变量进行单独拷贝

public class DP_Prototype {
}
