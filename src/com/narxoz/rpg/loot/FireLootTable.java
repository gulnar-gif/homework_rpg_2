package com.narxoz.rpg.loot;

import java.util.List;

public class FireLootTable extends BaseLootTable {
    public FireLootTable() {
        super(List.of("Fire Gem", "Flame Rune"), 300, 800);
    }
    @Override public LootTable clone() { return new FireLootTable(); }
}
