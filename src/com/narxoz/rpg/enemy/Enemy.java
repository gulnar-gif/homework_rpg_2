package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public interface Enemy {
    String getName();
    int getHealth();
    int getDamage();
    int getDefense();
    int getSpeed();

    String getElement();
    String getAIBehavior();

    List<Ability> getAbilities();
    LootTable getLootTable();

    void displayInfo();

    Enemy clone(); // DEEP COPY

    void multiplyStats(double multiplier);
    void setElement(String element);
    void setAIBehavior(String ai);
    void setAbilities(List<Ability> abilities);
    void addAbility(Ability ability);
    void setLootTable(LootTable lootTable);
}

