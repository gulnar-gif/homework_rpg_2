package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin implements Enemy {

    private String name;
    private int health = 100;
    private int damage = 15;
    private int defense = 5;
    private int speed = 35;

    private String element = "NONE";
    private String aiBehavior = "BASIC";

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public String getAIBehavior() { return aiBehavior; }

    @Override public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("HP=" + health + " DMG=" + damage + " DEF=" + defense + " SPD=" + speed);
        System.out.println("Element=" + element + " | AI=" + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) System.out.println("  - " + a);
        System.out.println("Loot: " + (lootTable == null ? "None" : lootTable.getLootInfo()));
        System.out.println();
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());
        copy.abilities = clonedAbilities;

        copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();

        return copy;
    }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int)Math.round(this.health * multiplier);
        this.damage = (int)Math.round(this.damage * multiplier);
        this.defense = (int)Math.round(this.defense * multiplier);
        this.speed  = (int)Math.round(this.speed * multiplier);
    }

    @Override public void setElement(String element) { this.element = element; }
    @Override public void setAIBehavior(String ai) { this.aiBehavior = ai; }

    @Override
    public void setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>();
        if (abilities != null) this.abilities.addAll(abilities);
    }

    @Override
    public void addAbility(Ability ability) {
        if (ability != null) this.abilities.add(ability);
    }

    @Override
    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }
}

