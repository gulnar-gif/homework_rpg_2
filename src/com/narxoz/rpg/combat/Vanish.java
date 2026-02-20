package com.narxoz.rpg.combat;

public class Vanish extends BaseAbility {
    public Vanish() {
        super("Vanish", 0, AbilityType.DEFENSE, "Becomes invisible.");
    }
    @Override public Ability clone() { return new Vanish(); }
}

