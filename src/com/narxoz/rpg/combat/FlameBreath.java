package com.narxoz.rpg.combat;

public class FlameBreath extends BaseAbility {
    public FlameBreath() {
        super("Flame Breath", 120, AbilityType.DAMAGE, "Breathes fire.");
    }
    @Override public Ability clone() { return new FlameBreath(); }
}

