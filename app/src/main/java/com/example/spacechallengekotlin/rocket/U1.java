package com.example.spacechallengekotlin.rocket;

public class U1 extends Rocket {
    double launchChance = 0.05;
    double landChance = 0.01;

    public U1() {
        cost = 100;
        rocketWeight = 10000;
        maxWeight = 18000;
    }

    @Override
    public boolean launch() {
        int coefficient = rocketWeight / maxWeight;
        return Math.random() >= launchChance * coefficient;
    }

    @Override
    public boolean land() {
        int coefficient = rocketWeight / maxWeight;
        return Math.random() >= landChance * coefficient;
    }

    @Override
    public int getCost() {
        return cost;
    }

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
