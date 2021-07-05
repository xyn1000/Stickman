package stickman.model.entity;

import stickman.model.Movable;
import stickman.model.entity.AbsEntity;

public class Hero extends AbsEntity implements Movable {
    private final double default_width = 20;
    private final double default_height = 34;
    private final double jump_height=4;
    private final double resistance=0.1;
    private final double xSpeed=1.5;

    private boolean right;
    private boolean left;
    private boolean jumping=false;
    private boolean ground = true;
    private boolean tile = false;

    private double yV=0;

    private double initialX;
    private double initialY;

    private Integer lives=3;
    private boolean shootAbility=false;
    private boolean shootLeft=false;
    private boolean shootRight=true;

    public Hero(double xPosition, double yPosition, String imagePath, Layer layer,String size) {
        super(xPosition, yPosition, imagePath, layer);
        this.width = getSize(size)[0];
        this.height = getSize(size)[1];
        this.yPosition-=this.height;

        this.initialX=xPosition;
        this.initialY=yPosition;
    }

    @Override
    public void move() {
        if (this.left && this.xPosition>=0){
            this.xPosition-=this.xSpeed;
            this.shootLeft=true;
            this.shootRight=false;
        }else if(this.right){
            this.xPosition+=this.xSpeed;
            this.shootRight=true;
            this.shootLeft=false;
        }

        if (this.isJumping()){
            this.startJump();
            this.yPosition += this.yV;
        }
        this.yPosition += this.yV;
        //System.out.println(this.yV);
    }

    public double[] getSize(String size){
        double[] temp = {this.default_width,this.default_height};
        switch (size){
            case "large":
                temp[0] *= 1.3;
                temp[1] *= 1.3;
                break;
            case "small":
                temp[0] *= 0.5;
                temp[1] *= 0.5;
                break;
            default:
                break;
        }
        return temp;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean setRight(boolean right) {
        this.right = right;
        return this.right;
    }

    public boolean setLeft(boolean left) {
        this.left = left;
        return this.left;
    }

    public boolean isJumping(){return this.jumping;}

    public boolean setJumping(boolean jump) {
        this.jumping=jump;
        return true;
    }

    public boolean isOnGround(){return this.ground;}

    public boolean setOnGround(boolean tmp){
        this.ground=tmp;
        if(tmp){
            this.jumping=false;
        }
        return this.ground;
    }

    public void startJump(){
        if ((this.ground || this.tile) && this.jumping){
            this.yV = -jump_height;
            this.setOnGround(false);
            this.setTile(false);
        }
    }

    public double getResistance() {
        return resistance;
    }

    public boolean isTile() {
        return tile;
    }

    public void setTile(boolean tile) {
        this.tile = tile;
    }

    public Integer getLives() {
        return lives;
    }

    public void setLives(Integer lives) {
        this.lives = lives;
    }

    public void die(){
        this.xPosition=this.initialX;
        this.yPosition=this.initialY-this.height;
        this.jumping=false;
        ground = true;
        yV=0;
    }

    public boolean isShootAbility() {
        return shootAbility;
    }

    public void setShootAbility(boolean shootAbility) {
        this.shootAbility = shootAbility;
    }

    public Bullet fire(){
        return new Bullet(this.xPosition,this.yPosition+this.height/2,"bullet.png",2,6,Layer.FOREGROUND,this);
    }

    public boolean isShootLeft() {
        return shootLeft;
    }

    public void setShootLeft(boolean shootLeft) {
        this.shootLeft = shootLeft;
    }

    public boolean isShootRight() {
        return shootRight;
    }

    public void setShootRight(boolean shootRight) {
        this.shootRight = shootRight;
    }

    public double getyV() {
        return yV;
    }

    public void setyV(double yV) {
        this.yV = yV;
    }
}
