package stickman.model.entity;

public interface Entity {
    String getImagePath();
    double getxPosition();
    double getyPosition();
    double getHeight();
    double getWidth();
    Layer getLayer();

    void setxPosition(double xPosition);
    void setImagePath(String imagePath);
    void setyPosition(double yPosition);
    void setHeight(double height);
    void setWidth(double width);
    void setLayer(Layer layer);


    enum Layer{
        BACKGROUND, FOREGROUND, EFFECT
    }
}
