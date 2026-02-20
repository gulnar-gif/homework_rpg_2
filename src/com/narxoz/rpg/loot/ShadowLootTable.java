package com.narxoz.rpg.loot;

import java.util.List;

public class ShadowLootTable extends BaseLootTable {
    public ShadowLootTable() {
        super(List.of("Shadow Gem", "Dark Essence"), 320, 850);
    }
    @Override public LootTable clone() { return new ShadowLootTable(); }
}
