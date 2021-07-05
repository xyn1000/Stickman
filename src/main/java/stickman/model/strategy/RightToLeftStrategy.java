package stickman.model.strategy;

import stickman.model.entity.Enemy;

public class RightToLeftStrategy  implements EnemyMovementStrategy{
    @Override
    public void enemyMove(Enemy enemy) {
        enemy.setxPosition(enemy.getxPosition()-enemy.getV());
    }
}