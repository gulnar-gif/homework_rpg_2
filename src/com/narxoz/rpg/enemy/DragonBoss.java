package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

        this.element = element;

        this.abilities = (abilities != null) ? abilities : new ArrayList<>();

        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);

        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;

        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
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
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName()
                    + " | dmg=" + a.getDamage()
                    + " | " + a.getDescription());
        }

        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> p : phases.entrySet()) {
            System.out.println("  Phase " + p.getKey() + ": triggers at " + p.getValue() + " HP");
        }

        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly
                + " | Breath Attack: " + hasBreathAttack
                + " | Wingspan: " + wingspan);

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
        List<Ability> abilitiesCopy = new ArrayList<>();
        for (Ability a : this.abilities) {
            abilitiesCopy.add(a.clone());
        }

        Map<Integer, Integer> phasesCopy = new HashMap<>(this.phases);

        LootTable lootCopy = (this.lootTable == null) ? null : this.lootTable.clone();

        DragonBoss copy = new DragonBoss(
                this.name,
                this.health,
                this.damage,
                this.defense,
                this.speed,
                this.element,
                abilitiesCopy,
                phasesCopy.getOrDefault(1, 0),
                phasesCopy.getOrDefault(2, 0),
                phasesCopy.getOrDefault(3, 0),
                lootCopy,
                this.aiBehavior,
                this.canFly,
                this.hasBreathAttack,
                this.wingspan
        );

        copy.phases = phasesCopy;

        return copy;
    }

    public DragonBoss withElement(String newElement) {
        DragonBoss copy = (DragonBoss) this.clone();
        copy.element = newElement;
        return copy;
    }

    public DragonBoss multiplyStats(double multiplier) {
        DragonBoss copy = (DragonBoss) this.clone();
        copy.health = (int) Math.round(copy.health * multiplier);
        copy.damage = (int) Math.round(copy.damage * multiplier);
        copy.defense = (int) Math.round(copy.defense * multiplier);
        copy.speed = (int) Math.round(copy.speed * multiplier);
        return copy;
    }
}

