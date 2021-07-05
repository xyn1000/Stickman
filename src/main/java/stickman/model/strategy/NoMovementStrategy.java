package stickman.model.strategy;

import stickman.model.entity.Enemy;

public class NoMovementStrategy implements EnemyMovementStrategy{
    @Override
    public void enemyMove(Enemy enemy) {
        //do nothing
    }
}