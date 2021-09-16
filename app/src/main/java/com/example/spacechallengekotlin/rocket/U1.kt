package com.example.spacechallengekotlin.rocket

class U1 : Rocket() {
    private val launchChance = 0.05
    private val landChance = 0.01

    init {
        cost = 100
        rocketWeight = 10000
        maxWeight = 18000
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