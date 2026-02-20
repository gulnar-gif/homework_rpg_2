package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseLootTable implements LootTable {

    protected final List<String> items;
    protected final int gold;
    protected final int experience;

    protected BaseLootTable(List<String> items, int gold, int experience) {
        this.items = new ArrayList<>(items);
        this.gold = gold;
        this.experience = experience;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return gold;
    }

    @Override
    public int getExperienceDrop() {
        return experience;
    }

    @Override
    public String getLootInfo() {
        return "Items: " + items + ", Gold: " + gold + ", EXP: " + experience;
    }

    @Override
    public abstract LootTable clone();

    @Override
    public String toString() {
        return getLootInfo();
    }
}
