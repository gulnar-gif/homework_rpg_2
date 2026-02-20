package com.narxoz.rpg.combat;

public class IceShield extends BaseAbility {
    public IceShield() {
        super("Ice Shield", 60, AbilityType.DEFENSE, "Ice barrier protects.");
    }
    @Override public Ability clone() { return new IceShield(); }
}

