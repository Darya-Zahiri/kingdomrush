package model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Tower {
    private int power;

    private int cost;

    private int radius;

    private int x;

    private int y;

    public Raider closestRaider;

    public Image explode=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\explodend.png");

    public Image dead=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\smoke.png");

    public Tower(int power,int cost,int radius) {
        this.power = power;
        this.cost=cost;
        this.radius=radius;
    }

    public int getPower() {
        return power;
    }

    public int getCost() {
        return cost;
    }

    public int getRadius() {
        return radius;
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
    public double getDistance(Raider raider){
        double distance=0.0;
        double towerX,towerY,raiderX,raiderY;
        double x,y;
        raiderX=raider.getX();
        raiderY=raider.getY();
        x=this.x-raiderX;
        y=this.y-raiderY;
        x=x*x;
        y=y*y;
        distance=Math.sqrt(x+y);
        return distance;
    }
    public double closeRaider(Wave wave){
        double answer;
        double distance;
        Raider close;
        answer=getDistance(wave.raiders.get(0));
        close=wave.raiders.get(0);
        for (int i=0;i<wave.raiders.size();i++){
            distance=getDistance(wave.raiders.get(i));
            if(distance<answer){
                answer=distance;
                close=wave.raiders.get(i);
            }
        }
        closestRaider=close;
        return answer;
    }
    public void shut(Wave wave){

        double distance=closeRaider(wave);


        System.out.println(distance);
        int number = 0;
        for(int i=0;i<wave.raiders.size();i++){
            if(wave.raiders.get(i).equals(closestRaider)){

                number=i;
                break;

            }
        }
        if (distance<radius) {
            int health=wave.raiders.get(number).getHealth();
            health--;
            if (health!=0) {
                Platform.runLater(() -> {
                    closestRaider.getImageView().setImage(explode);
                });

                wave.raiders.get(number).setHealth(health);
                String shoot="C:\\Users\\zam zam\\Downloads\\Rifle-Shooting.mp3";
                Media sound = new Media(new File(shoot).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            }else {
                Platform.runLater(() -> {
                    closestRaider.getImageView().setImage(dead);
                });

                wave.raiders.get(number).setHealth(health);

            }
        }
    }

}
