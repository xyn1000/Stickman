package stickman.model.entity;

import stickman.model.Movable;
import stickman.model.entity.AbsEntity;
import stickman.model.strategy.EnemyMovementStrategy;

public class Enemy extends AbsEntity implements Movable {
    private double v;
    private EnemyMovementStrategy strategy;

    public Enemy(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer, double velocity, EnemyMovementStrategy strategy) {
        super(xPosition, yPosition, imagePath, height, width, layer);
        this.v=velocity;
        this.strategy=strategy;
        this.yPosition-=this.height;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public EnemyMovementStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(EnemyMovementStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void move() {
        strategy.enemyMove(this);
//        System.out.println(this.height);
//        System.out.println(this.yPosition);
    }
}
