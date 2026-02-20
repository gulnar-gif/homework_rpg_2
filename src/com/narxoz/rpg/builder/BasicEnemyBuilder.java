package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name = "Goblin";
    private int health = 100;
    private int damage = 15;
    private int defense = 5;
    private int speed = 35;

    private String element = "NONE";
    private String ai = "BASIC";

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String ai) {
        this.ai = ai;
        return this;
    }

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

    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
        return this;
    }


    @Override
    public EnemyBuilder addPhase(int phase, int hpThreshold) {
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Enemy must have name");
        }

        Goblin g = new Goblin(name);

        g.setElement(element);
        g.setAIBehavior(ai);
        g.setAbilities(abilities);
        g.setLootTable(lootTable);


        if (health != 100) {
            g.multiplyStats(health / 100.0);
        }

        return g;
    }
}