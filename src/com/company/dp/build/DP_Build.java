package com.company.dp.build;

import java.util.ArrayList;

abstract class CarModel {
    private ArrayList<String> sequence = new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engine();
    final public void run() {
        for (int i = 0; i< this.sequence.size(); i++) {
            String action = this.sequence.get(i);
            switch (action) {
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "engine":
                    this.engine();
                    break;
                default:
                    break;
            }
        }
    }

    final public void setSequence(ArrayList sequence) {
        this.sequence = sequence;
    }
}

class Benz extends CarModel {
    @Override
    protected void alarm() {
        System.out.println("Benz alarm");
    }
    @Override
    protected void start() {
        System.out.println("Benz start");
    }
    @Override
    protected void stop() {
        System.out.println("Benz stop");
    }
    @Override
    protected void engine() {
        System.out.println("Benz engine");
    }
}

class BMW extends CarModel {
    @Override
    protected void alarm() {
        System.out.println("BMW alarm");
    }
    @Override
    protected void start() {
        System.out.println("BMW start");
    }
    @Override
    protected void stop() {
        System.out.println("BMW stop");
    }
    @Override
    protected void engine() {
        System.out.println("BMW engine");
    }
}

class Client {
    public static void main(String[] args) {
        Benz benz = new Benz();
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engine");
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");
        benz.setSequence(sequence);
        benz.run();
    }
}

// Add CarBuilder
abstract class CarBuilder {
    public abstract void setSequence(ArrayList<String> sequence);
    public abstract CarModel getCarModel();
}

class BenzBuilder extends CarBuilder {
    private Benz benz = new Benz();
    @Override
    public CarModel getCarModel() {
        return this.benz;
    }

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }
}

class BMWBuilder extends CarBuilder {
    private BMW bmw = new BMW();
    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }

    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }
}

class Client2 {
    public static void main(String[] args) {
        ArrayList<String> sequence = new ArrayList<>();
        sequence.add("engine");
        sequence.add("start");
        sequence.add("alarm");
        sequence.add("stop");
        BenzBuilder benzBuilder = new BenzBuilder();
        benzBuilder.setSequence(sequence);
        Benz benz = (Benz)benzBuilder.getCarModel();
        benz.run();

        BMWBuilder bmwBuilder = new BMWBuilder();
        bmwBuilder.setSequence(sequence);
        BMW bmw = (BMW) bmwBuilder.getCarModel();
        bmw.run();
    }
}

public class DP_Build {
    public static void main(String[] args) {

    }
}
