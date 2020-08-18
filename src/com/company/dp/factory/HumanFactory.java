package com.company.dp.factory;

public class HumanFactory extends AbstractFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (T)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("human generate error!");
        }
        return (T)human;
    }
}
