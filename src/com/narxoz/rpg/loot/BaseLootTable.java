package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class BaseLootTable implements LootTable {
    private final List<String> items;
    private final int gold;
    private final int exp;

    public BaseLootTable(List<String> items, int gold, int exp) {
        this.items = items == null ? new ArrayList<>() : new ArrayList<>(items);
        this.gold = gold;
        this.exp = exp;
    }

    @Override public List<String> getItems() { return new ArrayList<>(items); }
    @Override public int getGold() { return gold; }
    @Override public int getExp() { return exp; }

    @Override
    public String getLootInfo() {
        return "Items=" + items + ", Gold=" + gold + ", EXP=" + exp;
    }

    @Override
    public LootTable clone() {
        return new BaseLootTable(this.items, this.gold, this.exp);
    }
}
