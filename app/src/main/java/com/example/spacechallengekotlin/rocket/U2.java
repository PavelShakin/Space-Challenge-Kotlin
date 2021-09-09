package com.example.spacechallengekotlin.rocket;

public class U2 extends Rocket {
    double launchChance = 0.04;
    double landChance = 0.08;

    public U2() {
        cost = 120;
        rocketWeight = 18000;
        maxWeight = 29000;
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

    public int getRocketWeight() {
        return rocketWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
