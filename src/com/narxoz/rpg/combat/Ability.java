package com.narxoz.rpg.combat;

public interface Ability {
    String getName();
    int getPower();
    AbilityType getType();
    String getDescription();

    Ability clone();
}


