package com.narxoz.rpg.director;

import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    public Enemy createRaidBoss(EnemyComponentFactory factory, String name, String element) {
        return new BossEnemyBuilder()
                .setName(name)
                .setHealth(60000)
                .setDamage(650)
                .setDefense(260)
                .setSpeed(55)
                .setElement(element)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 60000)
                .addPhase(2, 35000)
                .addPhase(3, 15000)
                .build();
    }
}