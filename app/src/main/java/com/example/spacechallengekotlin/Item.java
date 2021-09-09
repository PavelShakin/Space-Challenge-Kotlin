package com.example.spacechallengekotlin;

public class Item implements Comparable<Item> {
    String name;
    int weight;

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(item.getWeight(), getWeight());
    }
}
