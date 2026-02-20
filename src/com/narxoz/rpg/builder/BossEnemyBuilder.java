package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage = 500;
    private int defense = 200;
    private int speed = 50;

    private String element = "FIRE";
    private String ai = "AGGRESSIVE";

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    private Map<Integer, Integer> phases = new HashMap<>();

    private boolean canFly = true;
    private boolean hasBreathAttack = true;
    private int wingspan = 20;

    public BossEnemyBuilder addPhase(int phase, int hpThreshold) {
        phases.put(phase, hpThreshold);
        return this;
    }

    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean b) { this.hasBreathAttack = b; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override public EnemyBuilder setAI(String ai) { this.ai = ai; return this; }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>();
        if (abilities != null) this.abilities.addAll(abilities);
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) this.abilities.add(ability);
        return this;
    }

    @Override public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank() || health <= 0) {
            throw new IllegalStateException("Boss must have name and health > 0");
        }

        if (phases.isEmpty()) {
            phases.put(1, health);
            phases.put(2, (int)(health * 0.6));
            phases.put(3, (int)(health * 0.3));
        }

        return new DragonBoss(
                name, health, damage, defense, speed,
                element,
                abilities,
                phases,
                lootTable,
                ai,
                canFly, hasBreathAttack, wingspan
        );
    }
}
