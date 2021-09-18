package com.example.spacechallengekotlin.rocket

class U1(cost: Int = 100,
         rocketWeight: Int = 10000,
         maxWeight: Int = 18000) : Rocket(cost, rocketWeight, maxWeight) {

    private val launchChance = 0.05
    private val landChance = 0.01

    override fun launch(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= launchChance * coefficient
    }

    override fun land(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= landChance * coefficient
    }
}