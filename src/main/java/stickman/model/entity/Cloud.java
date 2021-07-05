package stickman.model.entity;

import stickman.model.Movable;
import stickman.model.entity.AbsEntity;

public class Cloud extends AbsEntity implements Movable {
    private double v;

    public Cloud(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer,double velocity) {
        super(xPosition, yPosition, imagePath, height, width, layer);
        this.v=velocity;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    @Override
    public void move() {
        this.xPosition+=v;
    }
}
