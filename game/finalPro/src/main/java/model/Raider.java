package model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Raider {
    private int health;

    private int speed;

    private int loot;

    private int breakPoint;

    private Image image;

    private Label label;

    private ImageView imageView;

    private int x;

    private int y;

    public Raider(int health,int speed,int loot,int breakPoint,Image image) {
        this.health = health;
        this.speed=speed;
        this.loot=loot;
        this.breakPoint=breakPoint;
        this.image=image;
        this.label=new Label("");
        this.imageView=new ImageView(image);
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLoot() {
        return loot;
    }

    public int getBreakPoint() {
        return breakPoint;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void setBreakPoint(int breakPoint) {
        this.breakPoint = breakPoint;
    }

    public Image getImage() {
        return image;
    }

    public Label getLabel() {
        return label;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
