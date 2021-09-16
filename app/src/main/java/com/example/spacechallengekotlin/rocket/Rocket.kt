package com.example.spacechallengekotlin.rocket

import com.example.spacechallengekotlin.Item

open class Rocket : Spaceship {
    open var cost = 0
    open var rocketWeight = 0
    open var maxWeight = 0

    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(item: Item): Boolean {
        return rocketWeight + item.weight <= maxWeight
    }

    override fun carry(item: Item) {
        if (canCarry(item)) {
            rocketWeight += item.weight
        }
    }
}