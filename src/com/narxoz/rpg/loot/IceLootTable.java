package com.narxoz.rpg.loot;

import java.util.List;

public class IceLootTable extends BaseLootTable {
    public IceLootTable() {
        super(List.of("Ice Gem", "Frost Rune"), 280, 780);
    }
    @Override public LootTable clone() { return new IceLootTable(); }
}
