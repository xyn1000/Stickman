package stickman.model.entity;

public class Platform extends AbsEntity{
    public Platform(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer) {
        super(xPosition, yPosition, imagePath, height, width, layer);
    }


    public Platform copy(){
        return new Platform(xPosition,yPosition,imagePath,height,width,layer);
    }
}
