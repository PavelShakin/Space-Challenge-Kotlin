package com.example.spacechallengekotlin.rocket

import com.example.spacechallengekotlin.Item

open class Rocket (open var cost: Int,
                   open var rocketWeight: Int,
                   open var maxWeight: Int) : Spaceship {

    override fun launch(): Boolean = true

    override fun land(): Boolean = true

    override fun canCarry(item: Item): Boolean = rocketWeight + item.weight <= maxWeight

    override fun carry(item: Item) {
        if (canCarry(item)) {
            rocketWeight += item.weight
        }
    }
}