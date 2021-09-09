package com.example.spacechallengekotlin;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.spacechallengekotlin.rocket.Rocket;
import com.example.spacechallengekotlin.rocket.U1;
import com.example.spacechallengekotlin.rocket.U2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Simulation {
    private final Context mContext;

    public Simulation(Context context) {
        this.mContext = context;
    }

    public ArrayList<Item> loadItems(String path) {
        ArrayList<Item> items = new ArrayList<>();
        AssetManager am = mContext.getAssets();

        try (InputStream is = am.open(path);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] ln = line.split("=");
                Item item = new Item();
                item.setName(ln[0]);
                item.setWeight(Integer.parseInt(ln[1]));
                items.add(item);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> _items) {
        ArrayList<U1> rockets = new ArrayList<>();
        LinkedList<Item> items = new LinkedList<>(_items);

        Collections.sort(items);

        while (!items.isEmpty()) {
            U1 rocket = new U1();

            Iterator<Item> it = items.iterator();

            while (rocket.getRocketWeight() < rocket.getMaxWeight() && it.hasNext()) {
                Item i = it.next();

                if (rocket.canCarry(i)) {
                    rocket.carry(i);
                    it.remove();
                }
            }

            rockets.add(rocket);
        }

        return rockets;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> _items) {
        ArrayList<U2> rockets = new ArrayList<>();
        LinkedList<Item> items = new LinkedList<>(_items);

        Collections.sort(items);

        while (!items.isEmpty()) {
            U2 rocket = new U2();

            Iterator<Item> it = items.iterator();

            while (rocket.getRocketWeight() < rocket.getMaxWeight() && it.hasNext()) {
                Item i = it.next();

                if (rocket.canCarry(i)) {
                    rocket.carry(i);
                    it.remove();
                }
            }

            rockets.add(rocket);
        }

        return rockets;
    }

    public int runSimulation(List<? extends Rocket> rockets) {
        int budget = 0;
        int rocketCost = rockets.get(0).getCost();

        for (Rocket rocket : rockets) {
            do {
                budget += rocketCost;
            } while (!rocket.launch() || !rocket.land());
        }

        return budget;
    }
}
