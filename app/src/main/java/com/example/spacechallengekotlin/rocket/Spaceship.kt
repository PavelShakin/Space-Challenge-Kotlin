package com.example.spacechallengekotlin.rocket

import com.example.spacechallengekotlin.Item

interface Spaceship {
    fun launch(): Boolean
    fun land(): Boolean
    fun canCarry(item: Item): Boolean
    fun carry(item: Item)
}