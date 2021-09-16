package com.example.spacechallengekotlin.rocket

class U2 : Rocket() {
    private val launchChance = 0.04
    private val landChance = 0.08

    init {
        cost = 120
        rocketWeight = 18000
        maxWeight = 29000
    }

    override fun launch(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= launchChance * coefficient
    }

    override fun land(): Boolean {
        val coefficient = rocketWeight / maxWeight
        return Math.random() >= landChance * coefficient
    }
}