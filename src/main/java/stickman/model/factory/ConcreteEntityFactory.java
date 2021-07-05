package stickman.model.factory;

import stickman.model.entity.*;
import stickman.model.factory.EntityFactory;
import stickman.model.strategy.EnemyMovementStrategy;
import stickman.model.strategy.LeftToRightStrategy;
import stickman.model.strategy.NoMovementStrategy;
import stickman.model.strategy.RightToLeftStrategy;

import java.util.List;

public class ConcreteEntityFactory implements EntityFactory {
    @Override
    public Entity create(String type, double x, double y, List<Object> parameters) {
        switch (type.toLowerCase()){
            case "hero":
                return new Hero(x,y,"ch_stand1.png", Entity.Layer.FOREGROUND,(String) parameters.get(0));

            case "cloud":
                return new Cloud(
                        x,
                        y,
                        "cloud_1.png",
                        (double) parameters.get(0),
                        (double)parameters.get(1),
                        Entity.Layer.BACKGROUND,
                        (double)parameters.get(2));

            case "platform":
                return new Platform(
                        x,
                        y,
                        "platform.png",
                        (double) parameters.get(0),
                        (double) parameters.get(1),
                        Entity.Layer.BACKGROUND
                );

            case "enemy":
                String color=(String) parameters.get(4);
                String imagePath=null;
                if (color.equals("blue")){
                    imagePath="slimeBa.png";
                }else if (color.equals("green")){
                    imagePath="slimeGa.png";
                }else if (color.equals("purple")){
                    imagePath="slimePa.png";
                }else if (color.equals("red")){
                    imagePath="slimeRa.png";
                }else if (color.equals("yellow")){
                    imagePath="slimeYa.png";
                }else{
                    imagePath="slimeBa.png"; //default enemy
                }

                String strategy=(String) parameters.get(3);
                EnemyMovementStrategy movementStrategy=null;
                if (strategy.equals("leftToRight")){
                    movementStrategy=new LeftToRightStrategy();
                }else if(strategy.equals("noMovement")){
                    movementStrategy=new NoMovementStrategy();
                }else if(strategy.equals("rightToLeft")){
                    movementStrategy=new RightToLeftStrategy();
                }else{
                    movementStrategy=new NoMovementStrategy(); //default strategy
                }

                return new Enemy(
                        x,
                        y,
                        imagePath,
                        (double) parameters.get(0),
                        (double) parameters.get(1),
                        Entity.Layer.FOREGROUND,
                        (double) parameters.get(2),
                        movementStrategy
                );

            case "flag":
                return new Flag(
                        x,
                        y,
                        "flag.png",
                        (double) parameters.get(0),
                        (double) parameters.get(1),
                        Entity.Layer.BACKGROUND
                );

            case "mushroom":
                return new Mushroom(
                        x,
                        y,
                        "mushroom.png",
                        (double) parameters.get(0),
                        (double) parameters.get(1),
                        Entity.Layer.BACKGROUND
                );

            default:
                return null;

        }
    }
}
