package stickman.model.entity;

public class Mushroom extends AbsEntity{
    //private boolean eaten=false;

    public Mushroom(double xPosition, double yPosition, String imagePath, double height, double width, Layer layer) {
        super(xPosition, yPosition, imagePath, height, width, layer);
        this.yPosition-=this.height;
    }

//    public void disappear(){
//        this.eaten=true;
//    }
}
