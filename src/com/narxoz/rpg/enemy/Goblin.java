package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;
        this.abilities = new ArrayList<>();
        this.lootTable = null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName()
                    + " | dmg=" + a.getDamage()
                    + " | " + a.getDescription());
        }

        System.out.println("Loot:");
        if (lootTable == null) {
            System.out.println("  (no loot table)");
        } else {
            System.out.println("  Items: " + lootTable.getItems());
            System.out.println("  Gold: " + lootTable.getGoldDrop()
                    + " | XP: " + lootTable.getExperienceDrop());
        }
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;

        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }

        copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();

        return copy;
    }

    public void addAbility(Ability ability) {
        if (ability != null) abilities.add(ability);
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void multiplyStats(double multiplier) {
        this.health = (int) Math.round(this.health * multiplier);
        this.damage = (int) Math.round(this.damage * multiplier);
        this.defense = (int) Math.round(this.defense * multiplier);
        this.speed = (int) Math.round(this.speed * multiplier);
    }
}

