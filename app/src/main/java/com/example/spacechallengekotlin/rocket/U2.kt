package com.example.spacechallengekotlin.rocket

class U2(cost: Int = 120,
         rocketWeight: Int = 18000,
         maxWeight: Int = 29000) : Rocket(cost, rocketWeight, maxWeight) {

    private val launchChance = 0.04
    private val landChance = 0.08

    override fun launch(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= launchChance * coefficient
    }

    override fun land(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= landChance * coefficient
    }
}