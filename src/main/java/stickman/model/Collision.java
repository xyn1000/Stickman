package stickman.model;

import stickman.model.entity.Entity;
import stickman.model.entity.Hero;

public class Collision {
    public static boolean checkCollision(Entity a, Entity b){
        return (a.getxPosition() < (b.getxPosition() + b.getWidth())) &&
                ((a.getxPosition() + a.getWidth()) > b.getxPosition()) &&
                (a.getyPosition() < (b.getyPosition() + b.getHeight())) &&
                ((a.getyPosition() + a.getHeight()) > b.getyPosition());
    }

}
