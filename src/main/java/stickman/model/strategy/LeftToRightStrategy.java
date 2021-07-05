package stickman.model.strategy;

import stickman.model.entity.Enemy;

public class LeftToRightStrategy implements EnemyMovementStrategy{
    @Override
    public void enemyMove(Enemy enemy) {
        enemy.setxPosition(enemy.getxPosition()+enemy.getV());
    }
}
