package com.narxoz.rpg;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.director.EnemyDirector;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println(" RPG Enemy System - Creational Patterns Capstone \n");

        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        displayFactory("FIRE", fireFactory);
        displayFactory("ICE", iceFactory);
        displayFactory("SHADOW", shadowFactory);


        System.out.println("PART 2: BUILDER - Complex Enemy Construction");


        Enemy fireDragon = new BossEnemyBuilder()
                .setName("Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();

        fireDragon.displayInfo();

        EnemyDirector director = new EnemyDirector();
        Enemy raidBoss = director.createRaidBoss(shadowFactory, "Demon Lord", "SHADOW");
        raidBoss.displayInfo();


        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");


        EnemyRegistry registry = new EnemyRegistry();

        Enemy goblinTemplate = new Goblin("Goblin Template");
        registry.registerTemplate("goblin", goblinTemplate);

        registry.registerTemplate("fire-dragon", fireDragon);

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.setAIBehavior("ELITE");
        eliteGoblin.displayInfo();

        Enemy cloneDragon = registry.createFromTemplate("fire-dragon");
        cloneDragon.addAbility(fireFactory.createAbilities().get(0));

        System.out.println("Deep Copy Check:");
        System.out.println("Original dragon abilities = " + fireDragon.getAbilities().size());
        System.out.println("Clone dragon abilities    = " + cloneDragon.getAbilities().size());
        System.out.println();


        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");


        Enemy shadowBoss = new BossEnemyBuilder()
                .setName("Shadow Dragon")
                .setHealth(42000)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .addPhase(1, 42000)
                .addPhase(2, 25000)
                .addPhase(3, 12000)
                .build();

        registry.registerTemplate("shadow-boss", shadowBoss);

        Enemy strongerShadowBoss = registry.createFromTemplate("shadow-boss");
        strongerShadowBoss.multiplyStats(1.5);
        strongerShadowBoss.setAIBehavior("HARD");

        shadowBoss.displayInfo();
        strongerShadowBoss.displayInfo();


        System.out.println("PATTERN SUMMARY");
        System.out.println("Abstract Factory: Fire, Ice, Shadow component families");
        System.out.println("Builder: Step-by-step enemy construction (BossEnemyBuilder)");
        System.out.println("Factory Method: build() creates the Enemy object");
        System.out.println("Prototype: EnemyRegistry cloning with deep copy");
        System.out.println("\n= Demo Complete =");
    }

    private static void displayFactory(String theme, EnemyComponentFactory factory) {
        System.out.println(theme + " factory AI: " + factory.createAIBehavior());
        System.out.println(theme + " abilities: " + factory.createAbilities());
        System.out.println(theme + " loot: " + factory.createLootTable().getLootInfo());
        System.out.println();
    }
}
