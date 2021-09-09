package com.example.spacechallengekotlin.rocket;

import com.example.spacechallengekotlin.Item;

public interface Spaceship {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
