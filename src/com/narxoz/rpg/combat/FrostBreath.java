package com.narxoz.rpg.combat;

public class FrostBreath extends BaseAbility {
    public FrostBreath() {
        super("Frost Breath", 110, AbilityType.DAMAGE, "Breathes frost.");
    }
    @Override public Ability clone() { return new FrostBreath(); }
}
