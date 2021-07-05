package stickman.model;


import java.net.URL;

public class GameEngineImpl implements GameEngine{
    private Level level;

    public GameEngineImpl(String path) {
        URL url = Thread.currentThread().getContextClassLoader().getResource("level1.json");
        // To load 2nd level, please change the name of the file to "level2.json".

        String jsonpath= ((URL) url).getPath();
        JSONReader reader=new JSONReader(jsonpath);
        this.level = new LevelImpl(reader);
    }


    @Override
    public Level getCurrentLevel() {
        return this.level;
    }

    @Override
    public void startLevel() {

    }

    @Override
    public boolean jump() { return level.jump(); }

    @Override
    public boolean moveLeft() { return level.moveLeft(); }

    @Override
    public boolean moveRight() {
        return level.moveRight();
    }

    @Override
    public boolean stopMoving() {
        return level.stopMoving();
    }

    @Override
    public void tick() {
        this.level.tick();

    }

    @Override
    public void fire() {
        this.level.fire();

    }
}
