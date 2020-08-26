package com.company.dp.decorator;

abstract class SchoolReport {
    public abstract void report();
    public abstract void sign(String name);
}

abstract class Decorator extends SchoolReport {
    private SchoolReport report;
    public Decorator(SchoolReport report) {
        this.report = report;
    }
    @Override
    public void report() {
        this.report.report();
    }

    @Override
    public void sign(String name) {
        this.report.sign(name);
    }
}

class HighScoreDecorator extends Decorator {
    public HighScoreDecorator(SchoolReport report) {
        super(report);
    }

    private void reportHigh() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }
    @Override
    public void report() {
        this.reportHigh();
        super.report();
    }
}

class SortScoreDecorator extends Decorator {
    public SortScoreDecorator(SchoolReport report) {
        super(report);
    }

    private void sort() {
        System.out.println("我是排名第38名...");
    }
    @Override
    public void report() {
        super.report();
        this.sort();
    }
}


class FourReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("尊敬的XXX家长:");
        System.out.println(" ......");
        System.out.println(" 语文 62 数学65 体育 98 自然 63");
        System.out.println(" .......");
        System.out.println(" 家长签名： ");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名为：" + name);
    }
}

class Father {
    public static void main(String[] args) {
        SchoolReport report = new FourReport();
        report = new FourReport();
        report = new HighScoreDecorator(report);
        report = new SortScoreDecorator(report);
        report.report();
        report.sign("123");
    }
}


public class DP_Decorator {
    public static void main(String[] args) {

    }
}