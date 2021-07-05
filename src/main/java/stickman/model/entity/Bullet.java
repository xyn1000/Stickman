package stickman.model.entity;

import stickman.model.Movable;

public class Bullet extends AbsEntity implements Movable {
    private Double velocity=2.0;
    private Hero hero;
    private boolean shootRight=true;

    public Bullet(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer,Hero hero) {
        super(xPosition, yPosition, imagePath, height, width, layer);
        this.hero=hero;
        this.shootRight=hero.isShootRight();
    }

    @Override
    public void move() {
//        this.xPosition+=this.velocity;
        if (shootRight){
            this.xPosition+=this.velocity;
        }else{
            this.xPosition-=this.velocity;
        }
    }

    public Double getVelocity() {
        return velocity;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }
}
