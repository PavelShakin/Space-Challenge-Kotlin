package com.example.spacechallengekotlin

import android.content.Context
import com.example.spacechallengekotlin.rocket.U1
import com.example.spacechallengekotlin.rocket.U2
import com.example.spacechallengekotlin.rocket.Rocket
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

class Simulation(private val mContext: Context) {

    fun loadItems(path: String): ArrayList<Item> {
        val items = ArrayList<Item>()
        val am = mContext.assets

        try {
            am.open(path).use { reader ->
                BufferedReader(InputStreamReader(reader)).use { br ->
                    var line: String

                    while (br.readLine().also { line = it } != null) {
                        val ln = line.split("=").toTypedArray()
                        val item = Item()
                        item.name = ln[0]
                        item.weight = ln[1].toInt()
                        items.add(item)
                    }
                }
            }
        } catch (exception: IOException) {
            exception.printStackTrace()
        }

        return items
    }

    fun loadU1(_items: ArrayList<Item>): ArrayList<U1> {
        val rockets = ArrayList<U1>()
        val items = LinkedList(_items)

        items.sort()

        while (!items.isEmpty()) {
            val rocket = U1()
            val it = items.iterator()

            while (rocket.rocketWeight < rocket.maxWeight && it.hasNext()) {
                val i = it.next()

                if (rocket.canCarry(i)) {
                    rocket.carry(i)
                    it.remove()
                }
            }

            rockets.add(rocket)
        }

        return rockets
    }

    fun loadU2(_items: ArrayList<Item>): ArrayList<U2> {
        val rockets = ArrayList<U2>()
        val items = LinkedList(_items)

        items.sort()

        while (!items.isEmpty()) {
            val rocket = U2()
            val it = items.iterator()

            while (rocket.rocketWeight < rocket.maxWeight && it.hasNext()) {
                val i = it.next()

                if (rocket.canCarry(i)) {
                    rocket.carry(i)
                    it.remove()
                }
            }

            rockets.add(rocket)
        }

        return rockets
    }

    fun runSimulation(rockets: List<Rocket>): Int {
        var budget = 0
        val rocketCost = rockets[0].cost

        for (rocket in rockets) {
            do {
                budget += rocketCost
            } while (!rocket.launch() || !rocket.land())
        }

        return budget
    }
}