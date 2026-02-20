package com.narxoz.rpg.combat;

public class ShadowStrike extends BaseAbility {
    public ShadowStrike() {
        super("Shadow Strike", 115, AbilityType.DAMAGE, "Fast shadow hit.");
    }
    @Override public Ability clone() { return new ShadowStrike(); }
}

