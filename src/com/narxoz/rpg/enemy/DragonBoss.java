package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class DragonBoss implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;


    public DragonBoss(String name, int health, int damage, int defense,
               int speed, String element,
               List<Ability> abilities,
               Map<Integer, Integer> phases,
               LootTable lootTable, String aiBehavior,
               boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;

        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.phases = phases != null ? new HashMap<>(phases) : new HashMap<>();

        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;

        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
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
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("HP=" + health + " DMG=" + damage + " DEF=" + defense + " SPD=" + speed);
        System.out.println("Element=" + element + " | AI=" + aiBehavior);
        System.out.println("CanFly=" + canFly + " | Breath=" + hasBreathAttack + " | Wingspan=" + wingspan);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) System.out.println("  - " + a);

        System.out.println("Boss Phases:");
        List<Integer> keys = new ArrayList<>(phases.keySet());
        Collections.sort(keys);
        for (Integer k : keys) System.out.println("  Phase " + k + ": at " + phases.get(k) + " HP");

        System.out.println("Loot: " + (lootTable == null ? "None" : lootTable.getLootInfo()));
        System.out.println();
    }

    @Override
    public Enemy clone() {

        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) clonedAbilities.add(a.clone());


        Map<Integer, Integer> copiedPhases = new HashMap<>(this.phases);
        LootTable clonedLoot = (this.lootTable == null) ? null : this.lootTable.clone();

        return new DragonBoss(
                this.name, this.health, this.damage, this.defense, this.speed,
                this.element,
                clonedAbilities,
                copiedPhases,
                clonedLoot,
                this.aiBehavior,
                this.canFly, this.hasBreathAttack, this.wingspan
        );
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

