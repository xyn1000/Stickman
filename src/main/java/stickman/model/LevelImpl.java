package stickman.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import stickman.model.entity.Bullet;
import stickman.model.entity.Enemy;
import stickman.model.entity.Entity;
import stickman.model.entity.Hero;
import stickman.model.factory.ConcreteEntityFactory;
import stickman.model.factory.EntityFactory;
import stickman.model.strategy.EnemyMovementStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LevelImpl implements Level{
    private List<Entity> entities;
    private List<Bullet> bullets;
    private List<Enemy> enemies;
    private double height;
    private double width;
    private double floorHeight;
    private Hero hero;
    private EntityFactory factory;

    public LevelImpl(JSONReader reader) {
        this.entities = new ArrayList<>();
        this.bullets=new ArrayList<>();
        this.enemies=new ArrayList<>();
        this.factory=new ConcreteEntityFactory();
        updateSettings(reader);
        createEntities(reader);

        this.updateBulletList();
        this.updateEnemyList();
    }
    public void updateSettings(JSONReader reader){
        JSONObject setting=reader.getJSONObject("setting");
        this.height=reader.getDoubleFromJson(setting,"height");
        this.width=reader.getDoubleFromJson(setting,"width");
        this.floorHeight=reader.getDoubleFromJson(setting,"floorHeight");
    }

    public void createEntities(JSONReader reader){
        ArrayList<Object> heroList=new ArrayList<>();
        JSONObject stickman=reader.getJSONObject("stickman");
        Double heroX=reader.getDoubleFromJson(stickman,"x");
        String size=reader.getStringFromJson(stickman,"stickmanSize");
        heroList.add(size);
        this.hero=(Hero) factory.create("hero", heroX, floorHeight, heroList);

        JSONObject cloud1=reader.getJSONObject("cloud1");
        Double cloudVelocity=reader.getDoubleFromJson(cloud1,"cloudVelocity");
        Double cloudHeight=reader.getDoubleFromJson(cloud1,"cloudHeight");
        Double cloudWidth=reader.getDoubleFromJson(cloud1,"cloudWidth");
        Double cloudX=reader.getDoubleFromJson(cloud1,"cloudX");
        Double cloudY=reader.getDoubleFromJson(cloud1,"cloudY");
        ArrayList<Object> cloudList=new ArrayList<>();
        cloudList.add(cloudHeight);
        cloudList.add(cloudWidth);
        cloudList.add(cloudVelocity);
        Entity cloud=factory.create("cloud",cloudX,cloudY,cloudList);

        JSONObject enemy1=reader.getJSONObject("enemy1");
        Double enemyVelocity=reader.getDoubleFromJson(enemy1,"enemyVelocity");
        Double enemyHeight=reader.getDoubleFromJson(enemy1,"enemyHeight");
        Double enemyWidth=reader.getDoubleFromJson(enemy1,"enemyWidth");
        Double enemyX=reader.getDoubleFromJson(enemy1,"enemyX");
        Double enemyY=reader.getDoubleFromJson(enemy1,"enemyY");
        String color=reader.getStringFromJson(enemy1,"enemyColor");
        String strategy=reader.getStringFromJson(enemy1,"enemyMove");
        ArrayList<Object> enemyList=new ArrayList<>();
        enemyList.add(enemyHeight);
        enemyList.add(enemyWidth);
        enemyList.add(enemyVelocity);
        enemyList.add(strategy);
        enemyList.add(color);
        Entity enemy=factory.create("enemy",enemyX,enemyY,enemyList);

        JSONObject enemy2=reader.getJSONObject("enemy2");
        Double enemy2Velocity=reader.getDoubleFromJson(enemy2,"enemyVelocity");
        Double enemy2Height=reader.getDoubleFromJson(enemy2,"enemyHeight");
        Double enemy2Width=reader.getDoubleFromJson(enemy2,"enemyWidth");
        Double enemy2X=reader.getDoubleFromJson(enemy2,"enemyX");
        Double enemy2Y=reader.getDoubleFromJson(enemy2,"enemyY");
        String color2=reader.getStringFromJson(enemy2,"enemyColor");
        String strategy2=reader.getStringFromJson(enemy2,"enemyMove");
        ArrayList<Object> enemy2List=new ArrayList<>();
        enemy2List.add(enemy2Height);
        enemy2List.add(enemy2Width);
        enemy2List.add(enemy2Velocity);
        enemy2List.add(strategy2);
        enemy2List.add(color2);
        Entity enemy2nd=factory.create("enemy",enemy2X,enemy2Y,enemy2List);

        Double platformHeight = reader.getDoubleFromJson(reader.getConfiguration(),"platformHeight");
        Double platformWidth = reader.getDoubleFromJson(reader.getConfiguration(),"platformWidth");

        JSONObject platform1=reader.getJSONObject("platform1");
        Double platform1X=reader.getDoubleFromJson(platform1,"x");
        Double platform1Y=reader.getDoubleFromJson(platform1,"y");

        JSONObject platform2=reader.getJSONObject("platform2");
        Double platform2X=reader.getDoubleFromJson(platform2,"x");
        Double platform2Y=reader.getDoubleFromJson(platform2,"y");

        JSONObject platform3=reader.getJSONObject("platform3");
        Double platform3X=reader.getDoubleFromJson(platform3,"x");
        Double platform3Y=reader.getDoubleFromJson(platform3,"y");

        ArrayList<Object> platformsList=new ArrayList<>();
        platformsList.add(platformHeight);
        platformsList.add(platformWidth);

        Entity platform1st=factory.create("platform",platform1X,platform1Y,platformsList);
        Entity platform2nd=factory.create("platform",platform2X,platform2Y,platformsList);
        Entity platform3rd=factory.create("platform",platform3X,platform3Y,platformsList);

        JSONObject flag=reader.getJSONObject("flag");
        Double flagHeight=reader.getDoubleFromJson(flag,"Height");
        Double flagWidth=reader.getDoubleFromJson(flag,"Width");
        Double flagX=reader.getDoubleFromJson(flag,"x");
        Double flagY=reader.getDoubleFromJson(flag,"y");
        ArrayList<Object> flagList=new ArrayList<>();
        flagList.add(flagHeight);
        flagList.add(flagWidth);
        Entity flag1=factory.create("flag",flagX,flagY,flagList);

        JSONObject mushroom=reader.getJSONObject("mushroom");
        Double mushroomHeight=reader.getDoubleFromJson(mushroom,"Height");
        Double mushroomWidth=reader.getDoubleFromJson(mushroom,"Width");
        Double mushroomX=reader.getDoubleFromJson(mushroom,"x");
        Double mushroomY=reader.getDoubleFromJson(mushroom,"y");
        ArrayList<Object> mushroomList=new ArrayList<>();
        mushroomList.add(mushroomHeight);
        mushroomList.add(mushroomWidth);
        Entity mushroom1=factory.create("mushroom",mushroomX,mushroomY,mushroomList);

        entities.add(this.hero);
        entities.add(cloud);
        entities.add(enemy);
        entities.add(enemy2nd);
        entities.add(platform1st);
        entities.add(platform2nd);
        entities.add(platform3rd);
        entities.add(flag1);
        entities.add(mushroom1);
    }

    public void updateBulletList(){
        for (Entity e:entities){
            if(e instanceof Bullet && !bullets.contains(e)){
                this.bullets.add((Bullet) e);
            }
        }
    }
    public void updateEnemyList(){
        for (Entity e:entities){
            if(e instanceof Enemy && !enemies.contains(e)){
                this.enemies.add((Enemy) e);
            }
        }
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() { return this.width; }

    @Override
    public void tick() {
        this.updateBulletList();
        this.updateEnemyList();
        //System.out.println(this.hero.getyPosition());
        for (Entity e:entities) {
            if (e instanceof Movable){
                ((Movable) e).move();
            }
        }
        updateVelocity();
        checkOnGround();
        List<Entity> marks=new ArrayList<>();
        for (int i=1;i<entities.size();i++){
            boolean mark=Collision.checkCollision(this.hero,entities.get(i));
            if(mark){
                marks.add(entities.get(i));
            }
        }
        for (int j=0;j<marks.size();j++){
            CollisionHandler.HandleHeroCollision(this.hero,marks.get(j),this);
        }


        CollisionHandler.HandleBulletCollision(this);
    }

    @Override
    public double getFloorHeight() {
        return this.floorHeight;
    }

    public void updateVelocity(){
        hero.setyV(hero.getyV() + hero.getResistance());
    }

    @Override
    public double getHeroX() {
        return this.hero.getxPosition();
    }

    @Override
    public boolean jump() {
        return this.hero.setJumping(true);
    }

    @Override
    public boolean moveLeft() {
        this.hero.setRight(false);
        return this.hero.setLeft(true);
    }

    public void checkOnGround(){
        if (hero.getyPosition() + hero.getHeight()>=this.floorHeight){
            hero.setyPosition(this.floorHeight - hero.getHeight());
            hero.setyV(0);
            hero.setOnGround(true);
            hero.setJumping(false);
        }
    }

    @Override
    public boolean moveRight() {
        this.hero.setLeft(false);
        return this.hero.setRight(true);
    }

    @Override
    public boolean stopMoving() {
        this.hero.setLeft(false);
        this.hero.setRight(false);
        return true;
    }

    @Override
    public void fire() {
        if(this.hero.isShootAbility()){
            entities.add(this.hero.fire());
        }

    }
}
