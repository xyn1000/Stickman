package stickman.model;

import stickman.model.entity.Bullet;
import stickman.model.entity.Enemy;
import stickman.model.entity.Entity;

import java.util.List;

public interface Level {
    List<Entity> getEntities();
    double getHeight();
    double getWidth();

    void tick();

    double getFloorHeight();
    double getHeroX();

    boolean jump();
    boolean moveLeft();
    boolean moveRight();
    boolean stopMoving();

    List<Bullet> getBullets();
    List<Enemy> getEnemies();
    void fire();

}
