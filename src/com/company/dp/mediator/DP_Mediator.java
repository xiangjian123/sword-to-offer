package com.company.dp.mediator;


import javax.swing.*;
import java.util.Random;

abstract class AMediator {
    protected Purchase purchase;
    protected Sale sale;
    protected Stock stock;
    public AMediator() {
        purchase = new Purchase(this);
        sale = new Sale(this);
        stock = new Stock(this);
    }
    public abstract void execute(String str, Object...objects);
}

class M1 extends AMediator {
    @Override
    public void execute(String str, Object...objects) {
        if (str.equals("purchase.buy")) {
            this.buy((Integer) objects[0]);
        } else if (str.equals("sale.sell")) {
            this.sell((Integer) objects[0]);
        }  else if (str.equals("sale.offsell")) {
            this.offSell();
        } else if (str.equals("stock.clear")) {
            this.clearStock();
        }
    }
    private void buy(int num) {
        int sale = super.sale.getSaleState();
        if (sale > 80) {
            System.out.println("buy " + num);
            super.stock.increase(num);
        } else {
            int n = num / 2;
            System.out.println("buy " + n);
            super.stock.increase(n);
        }
    }

    private void sell(int num) {
        if (super.stock.getStockNum() < num) {
            super.purchase.buyComputer(num);
        }
        super.stock.decrease(num);
    }

    private void offSell() {
        System.out.println("折价销售IBM电脑"+stock.getStockNum()+"台");
    }

    private void clearStock() {
        super.sale.offSale();
        super.purchase.refuseBuy();
    }
}

abstract class AColleague {
    protected AMediator mediator;
    public AColleague(AMediator mediator) {
        this.mediator = mediator;
    }
}

class Purchase extends AColleague {
    public Purchase(AMediator mediator) {
        super(mediator);
    }

    public void buyComputer(int num) {
        super.mediator.execute("purchase.buy", num);
    }

    public void refuseBuy() {
        System.out.println("refuse buy");
    }
}

class Sale extends AColleague {
    public Sale(AMediator mediator) {
        super(mediator);
    }

    public void sell(int num) {
        super.mediator.execute("sale.sell", num);
        System.out.println("sell " + num + " computer");
    }

    public int getSaleState() {
        Random rand = new Random(System.currentTimeMillis());
        int saleStatus = rand.nextInt(100);
        System.out.println("IBM电脑的销售情况为："+saleStatus);
        return saleStatus;
    }
    public void offSale() {
        super.mediator.execute("sale.offsell");
    }
}

class Stock extends AColleague {
    public Stock(AMediator mediator) {
        super(mediator);
    }

    private static int NUMBER = 100;

    public void increase(int num) {
        NUMBER += num;
        System.out.println("stock " + NUMBER);
    }

    public void decrease(int num) {
        NUMBER -= num;
        System.out.println("stock " + NUMBER);
    }

    public int getStockNum() {
        return NUMBER;
    }

    public void clearStock() {
        System.out.println("clear stock " + NUMBER);
        super.mediator.execute("stock.clear");
    }
}


class Client {
    public static void main(String[] args) {
        AMediator mediator = new M1();
        Purchase purchase = new Purchase(mediator);
        Sale sale = new Sale(mediator);
        Stock stock = new Stock(mediator);

        purchase.buyComputer(100);
        sale.sell(1);
        stock.clearStock();
    }
}




public class DP_Mediator {
}
