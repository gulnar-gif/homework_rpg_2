package com.narxoz.rpg;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        showFactory("FIRE", fireFactory);
        showFactory("ICE", iceFactory);
        showFactory("SHADOW", shadowFactory);

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // BossEnemyBuilder bossBuilder = new BossEnemyBuilder();
        // Enemy fireDragon = bossBuilder
        //         .setName("Ancient Fire Dragon")
        //         .setHealth(50000)
        //         .setDamage(500)
        //         .setDefense(200)
        //         .setSpeed(50)
        //         .setElement("FIRE")
        //         .setAbilities(fireFactory.createAbilities())
        //         .setLootTable(fireFactory.createLootTable())
        //         .setAI(fireFactory.createAIBehavior())
        //         .addPhase(1, 50000)
        //         .addPhase(2, 30000)
        //         .addPhase(3, 15000)
        //         .build();
        //
        // fireDragon.displayInfo();
        // System.out.println();

        Enemy goblin = new Goblin("Forest Goblin");
        goblin.displayInfo();
        System.out.println();

        // TODO: Director демо (бар болса)
        // EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        // Enemy miniBoss = director.createMiniBoss(fireFactory);
        // Enemy raidBoss = director.createRaidBoss(iceFactory);
        // miniBoss.displayInfo();
        // System.out.println();
        // raidBoss.displayInfo();
        // System.out.println();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");
        // EnemyRegistry registry = new EnemyRegistry();
        //
        // Enemy goblinTemplate = new Goblin("Goblin Template");
        // registry.registerTemplate("goblin", goblinTemplate);
        //
        // Enemy eliteGoblin = registry.createFromTemplate("goblin");
        // if (eliteGoblin instanceof Goblin) {
        //     ((Goblin) eliteGoblin).multiplyStats(2.0);
        // }
        // eliteGoblin.displayInfo();
        // System.out.println();
        //

        // Enemy cloneTest = registry.createFromTemplate("goblin");
        // if (cloneTest instanceof Goblin) {
        // cloneTest-ке ability қос (сенде addAbility бар)
        //     // ((Goblin) cloneTest).addAbility(new SOME_ABILITY());
        // }
        // System.out.println("Template (original) abilities size: " + goblinTemplate.getAbilities().size());
        // System.out.println("Clone abilities size: " + cloneTest.getAbilities().size());
        // System.out.println();

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");


        
        // 1) shadowFactory дайын
        // 2) builder арқылы shadow boss build
        // 3) registry.registerTemplate(...)
        // 4) registry.createFromTemplate(...) арқылы variant
        //
        // Enemy shadowBoss = new BossEnemyBuilder()
        //         .setName("Shadow Demon Lord")
        //         .setHealth(60000)
        //         .setDamage(700)
        //         .setDefense(250)
        //         .setSpeed(60)
        //         .setElement("SHADOW")
        //         .setAbilities(shadowFactory.createAbilities())
        //         .setLootTable(shadowFactory.createLootTable())
        //         .setAI(shadowFactory.createAIBehavior())
        //         .addPhase(1, 60000)
        //         .addPhase(2, 40000)
        //         .addPhase(3, 20000)
        //         .build();
        //
        // registry.registerTemplate("shadow-boss", shadowBoss);
        // Enemy greater = registry.createFromTemplate("shadow-boss");
        // greater.displayInfo();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================\n");

        System.out.println("Abstract Factory: Fire/Ice/Shadow themed component families");
        System.out.println("Builder: Step-by-step construction of complex enemies");
        System.out.println("Factory Method: build() method creates Enemy products");
        System.out.println("Prototype: EnemyRegistry clones templates (deep copy)");

        System.out.println("\n=== Demo Complete ===");
    }

    private static void showFactory(String theme, EnemyComponentFactory factory) {
        List<Ability> abilities = factory.createAbilities();
        LootTable loot = factory.createLootTable();
        String ai = factory.createAIBehavior();

        System.out.println("[" + theme + "]");
        System.out.println("AI: " + ai);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + " | dmg=" + a.getDamage());
        }

        System.out.println("Loot:");
        if (loot == null) {
            System.out.println("  (no loot)");
        } else {
            System.out.println("  Items: " + loot.getItems());
            System.out.println("  Gold: " + loot.getGoldDrop() + " | XP: " + loot.getExperienceDrop());
        }

        System.out.println();
    }
}
