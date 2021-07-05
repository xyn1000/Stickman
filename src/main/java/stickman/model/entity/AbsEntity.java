package stickman.model.entity;

public abstract class AbsEntity implements Entity {
    protected double xPosition;
    protected double yPosition;
    protected String imagePath;
    protected double height;
    protected double width;
    protected Layer layer;

    public AbsEntity(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.imagePath = imagePath;
        this.height = height;
        this.width = width;
        this.layer = layer;
    }

    public AbsEntity(double xPosition, double yPosition, String imagePath, Layer layer) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.imagePath = imagePath;
        this.layer = layer;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public double getxPosition() {
        return xPosition;
    }

    @Override
    public double getyPosition() {
        return yPosition;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    @Override
    public void setxPosition(double xPosition){
        this.xPosition=xPosition;
    }

    @Override
    public void setImagePath(String imagePath){
        this.imagePath=imagePath;
    }

    @Override
    public void setyPosition(double yPosition){
        this.yPosition=yPosition;
    }

    @Override
    public void setHeight(double height){
        this.height=height;
    }

    @Override
    public void setWidth(double width){
        this.width=width;
    }

    @Override
    public void setLayer(Layer layer){
        this.layer=layer;
    }

}
