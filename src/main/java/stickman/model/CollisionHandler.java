package stickman.model;

import stickman.model.entity.*;

import java.net.CookieHandler;

public class CollisionHandler {
    public static void HandleHeroCollision(Hero hero, Entity b, Level level){
        if (b instanceof Enemy){
            hero.setLives(hero.getLives()-1);
            hero.die();
        }else if (b instanceof Platform){
            if (hero.getyV() < 0 ){
                //(hero.getyPosition()+hero.getHeight()>=b.getyPosition())
                hero.setyV(-hero.getyV());
            } else {
                    hero.setyV(0);
                    hero.setTile(true);
                    hero.setJumping(false);
                    hero.setyPosition(b.getyPosition()-hero.getHeight());
            }

        }else if (b instanceof Flag){
            //win the game
            System.out.println("exit");
            System.exit(0);
        }else if (b instanceof Mushroom){
            hero.setShootAbility(true);
            level.getEntities().remove(b);
        }


        if (hero.getLives()<=0){
            System.out.println("game over");
            System.exit(0);

        }

    }

    public static void HandleBulletCollision(Level level){

        for (int i = 0; i < level.getBullets().size(); i++) {
            for (int j = 0; j < level.getEnemies().size(); j++) {
                if (Collision.checkCollision(level.getBullets().get(i), level.getEnemies().get(j))){
                    level.getEntities().remove(level.getBullets().get(i));
                    level.getEntities().remove(level.getEnemies().get(j));
                    level.getEnemies().remove(j);
                    j--;
                    level.getBullets().remove(i);
                    i--;
                }
            }
        }
    }
}
