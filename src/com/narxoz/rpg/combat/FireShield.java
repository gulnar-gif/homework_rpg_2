package com.narxoz.rpg.combat;

public class FireShield extends BaseAbility {
    public FireShield() {
        super("Fire Shield", 50, AbilityType.DEFENSE, "Flame shield protects.");
    }
    @Override public Ability clone() { return new FireShield(); }
}

