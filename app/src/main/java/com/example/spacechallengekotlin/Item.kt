package com.example.spacechallengekotlin

class Item : Comparable<Item> {
    var name: String? = null
    var weight = 0

    override fun compareTo(other: Item): Int {
        return other.weight.compareTo(weight)
    }
}