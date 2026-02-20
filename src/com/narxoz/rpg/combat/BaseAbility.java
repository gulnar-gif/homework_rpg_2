package com.narxoz.rpg.combat;

public abstract class BaseAbility implements Ability {

    private final String name;
    private final int power;
    private final AbilityType type;
    private final String description;

    protected BaseAbility(String name, int power, AbilityType type, String description) {
        this.name = name;
        this.power = power;
        this.type = type;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public AbilityType getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public abstract Ability clone();

    @Override
    public String toString() {
        return name + " [" + type + "] power=" + power + " (" + description + ")";
    }
}

