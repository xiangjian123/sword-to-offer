package com.company.dp.proxy;


interface IGamePlayer {
    public void login(String user, String password);
    public void killBoss();
    public void upgrade();
}

class GamePlayerProxy implements IGamePlayer {
    private IGamePlayer gamePlayer = null;
    public GamePlayerProxy(IGamePlayer iGamePlayer) {
        this.gamePlayer = iGamePlayer;
    }

    @Override
    public void killBoss() {
        this.gamePlayer.killBoss();
    }

    @Override
    public void login(String user, String password) {
        this.gamePlayer.login(user, password);
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
    }
}

class GamePlayer implements IGamePlayer {
    private String name = "";
    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + " kill boss");
    }

    @Override
    public void login(String user, String password) {
        System.out.println(user + " login success");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + " upgrade");
    }
}

class Client {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("xniu");

        IGamePlayer proxy = new GamePlayerProxy(player);
        proxy.login("xniu", "123456");
        proxy.killBoss();
        proxy.upgrade();
    }
}

// 代理类的构造函数中传递被代理的对象

public class DP_Proxy {
}
