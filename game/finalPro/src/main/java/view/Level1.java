package view;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

import java.io.IOException;
import java.util.ArrayList;

public class Level1 implements Runnable{
    Stage stage;
    Scene scene;
    Parent root;
    public ArrayList<Tower> towers=new ArrayList<>();
    @FXML
    private AnchorPane anchor;
    @FXML
    private Label tower1L;
    @FXML
    private Label tower2L;
    @FXML
    private Label tower3L;
    @FXML
    private Label life;
    @FXML
    private Label coin;
    @FXML
    private Label wave;
    @FXML
    private Button homeB;
    @FXML
    private ImageView home;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView ghost;
    @FXML
    private ImageView tower1;
    @FXML
    private ImageView tower2;
    @FXML
    private ImageView tower3;
    @FXML
    private ImageView board;
    @FXML
    private ImageView ring1;
    @FXML
    private ImageView ring2;
    @FXML
    private ImageView ring3;
    @FXML
    private Button button;
    @FXML
    private Button tower1B;
    @FXML
    private Button tower2B;
    @FXML
    private Button tower3B;
    @FXML
    private Button archer1B;
    @FXML
    private Button archer2B;
    @FXML
    private Button archer3B;
    @FXML
    private Button barracks1B;
    @FXML
    private Button barracks2B;
    @FXML
    private Button barracks3B;
    @FXML
    private Button mages1B;
    @FXML
    private Button mages2B;
    @FXML
    private Button mages3B;
    @FXML
    private Button artillery1B;
    @FXML
    private Button artillery2B;
    @FXML
    private Button artillery3B;
    @FXML
    private ImageView attack;
    private Image map1=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\map1.png");
    private Image homeI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\home.png");
    private Image towerI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\towerplace.png");
    private Image boardI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\board.png");
    private Image ringI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\ring.png");
    private Image upgrade=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\upgrade.png");
    private Image attackI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\start1.png");

    Map level1=new Map(300,20,0);
    Wave currentWave=new Wave();
    public int waveCount=0;

    public void initialize(){
        life.setText(String.valueOf(level1.getLife()));
        coin.setText(String.valueOf(level1.getCoin()));
        wave.setText("0/4");
        attack.setImage(attackI);
        disable();
        ring1.setImage(ringI);
        ring2.setImage(ringI);
        ring3.setImage(ringI);
        board.setImage(boardI);
        tower1.setImage(towerI);
        tower2.setImage(towerI);
        tower3.setImage(towerI);
        home.setImage(homeI);
        imageView.setImage(map1);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void click(ActionEvent event){
        switch (waveCount){
            case 0:
                level1.setWave(1);
                currentWave = new wave1();
                waveCount++;
                break;

            case 1:
                level1.setWave(2);
                currentWave = new Wave2();
                waveCount++;
                break;
            case 2:

                level1.setWave(3);
                currentWave = new Wave3();
                waveCount++;
                break;
            case 3:

                level1.setWave(4);
                currentWave = new Wave4();
                waveCount++;
                break;
        }

        currentWave.raiders.forEach(entry -> {
            move(entry);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
    public void setHomeB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setTower1B(){
        disable();
        if (tower1.getImage().equals(towerI)){
            ring1.setOpacity(1);
            archer1B.setDisable(false);
            barracks1B.setDisable(false);
            mages1B.setDisable(false);
            artillery1B.setDisable(false);
        }else {
            ring1.setImage(upgrade);
            ring1.setOpacity(1);
            ring1.setLayoutY(40);
        }

    }
    public void setTower2B(){
        disable();
        if (tower2.getImage().equals(towerI)){
            ring2.setOpacity(1);
            archer2B.setDisable(false);
            barracks2B.setDisable(false);
            mages2B.setDisable(false);
            artillery2B.setDisable(false);
        }else {
            ring2.setImage(upgrade);
            ring2.setOpacity(1);
            //ring1.setLayoutY(40);
        }

    }
    public void setTower3B(){
        disable();
        if (tower3.getImage().equals(towerI)){
            ring3.setOpacity(1);
            archer3B.setDisable(false);
            barracks3B.setDisable(false);
            mages3B.setDisable(false);
            artillery3B.setDisable(false);
        }else {
            ring3.setImage(upgrade);
            ring3.setOpacity(1);
            //ring1.setLayoutY(40);
        }
    }
    public void setArcher1B(){
        disable();
        Archer archer=new Archer();
        tower1.setImage(archer.getImag());
        tower1.setLayoutX(155);
        archer.setX((int) (tower1.getLayoutX()+65));
        archer.setY((int) (tower1.getLayoutY()+32));
        towers.add(archer);
        int cost=level1.getCoin();
        cost-=archer.getCost();
        level1.setCoin(cost);
    }
    public void setBarracks1B(){
        disable();
        Barracks barracks=new Barracks();
        tower1.setImage(barracks.getImag());
        tower1.setLayoutX(155);
        barracks.setX((int) (tower1.getLayoutX()+65));
        barracks.setY((int) (tower1.getLayoutY()+32));
        towers.add(barracks);

        int cost=level1.getCoin();
        cost-=barracks.getCost();
        level1.setCoin(cost);
    }
    public void setMages1B(){
        disable();
        Mages mages=new Mages();
        tower1.setImage(mages.getImag());
        tower1.setLayoutX(155);
        mages.setX((int) (tower1.getLayoutX()+65));
        mages.setY((int) (tower1.getLayoutY()+32));
        towers.add(mages);

        int cost=level1.getCoin();
        cost-=mages.getCost();
        level1.setCoin(cost);
    }
    public void setArtillery1B(){
        disable();
        Artillery artillery=new Artillery();
        tower1.setImage(artillery.getImag());
        tower1.setLayoutX(155);
        artillery.setX((int) (tower1.getLayoutX()+65));
        artillery.setY((int) (tower1.getLayoutY()+32));
        towers.add(artillery);

        int cost=level1.getCoin();
        cost-=artillery.getCost();
        level1.setCoin(cost);
    }


    public void setArcher2B(){
        disable();
        Archer archer=new Archer();
        tower2.setImage(archer.getImag());
        tower2.setLayoutX(225);
        archer.setX((int) (tower2.getLayoutX()+65));
        archer.setY((int) (tower2.getLayoutY()+32));
        towers.add(archer);

        int cost=level1.getCoin();
        cost-=archer.getCost();
        level1.setCoin(cost);
    }
    public void setBarracks2B(){
        disable();
        Barracks barracks=new Barracks();
        tower2.setImage(barracks.getImag());
        tower2.setLayoutX(225);
        tower2.setLayoutY(240);
        barracks.setX((int) (tower2.getLayoutX()+65));
        barracks.setY((int) (tower2.getLayoutY()+32));
        towers.add(barracks);

        int cost=level1.getCoin();
        cost-=barracks.getCost();
        level1.setCoin(cost);
    }
    public void setMages2B(){
        disable();
        Mages mages=new Mages();
        tower2.setImage(mages.getImag());
        tower2.setLayoutX(225);
        tower2.setLayoutY(235);
        mages.setX((int) (tower2.getLayoutX()+65));
        mages.setY((int) (tower2.getLayoutY()+32));
        towers.add(mages);

        int cost=level1.getCoin();
        cost-=mages.getCost();
        level1.setCoin(cost);
    }
    public void setArtillery2B(){
        disable();
        Artillery artillery=new Artillery();
        tower2.setImage(artillery.getImag());
        tower2.setLayoutX(225);
        tower2.setLayoutY(235);
        artillery.setX((int) (tower2.getLayoutX()+65));
        artillery.setY((int) (tower2.getLayoutY()+32));
        towers.add(artillery);

        int cost=level1.getCoin();
        cost-=artillery.getCost();
        level1.setCoin(cost);
    }

    public void setArcher3B(){
        disable();
        Archer archer=new Archer();
        tower3.setImage(archer.getImag());
        tower3.setLayoutX(85);
        archer.setX((int) (tower3.getLayoutX()+65));
        archer.setY((int) (tower3.getLayoutY()+32));
        towers.add(archer);

        int cost=level1.getCoin();
        cost-=archer.getCost();
        level1.setCoin(cost);
    }
    public void setBarracks3B(){
        disable();
        Barracks barracks=new Barracks();
        tower3.setImage(barracks.getImag());
        tower3.setLayoutX(85);
        tower3.setLayoutY(316);
        barracks.setX((int) (tower3.getLayoutX()+65));
        barracks.setY((int) (tower3.getLayoutY()+32));
        towers.add(barracks);

        int cost=level1.getCoin();
        cost-=barracks.getCost();
        level1.setCoin(cost);
    }
    public void setMages3B(){
        disable();
        Mages mages=new Mages();
        tower3.setImage(mages.getImag());
        tower3.setLayoutX(85);
        mages.setX((int) (tower3.getLayoutX()+65));
        mages.setY((int) (tower3.getLayoutY()+32));
        towers.add(mages);

        int cost=level1.getCoin();
        cost-=mages.getCost();
        level1.setCoin(cost);
    }
    public void setArtillery3B(){
        disable();
        Artillery artillery=new Artillery();
        tower3.setImage(artillery.getImag());
        tower3.setLayoutX(85);
        tower3.setLayoutY(316);
        artillery.setX((int) (tower3.getLayoutX()+65));
        artillery.setY((int) (tower3.getLayoutY()+32));
        towers.add(artillery);

        int cost=level1.getCoin();
        cost-=artillery.getCost();
        level1.setCoin(cost);
    }

    public void disable(){
        //tower Buttons
        archer1B.setDisable(true);
        archer2B.setDisable(true);
        archer3B.setDisable(true);
        barracks1B.setDisable(true);
        barracks2B.setDisable(true);
        barracks3B.setDisable(true);
        mages1B.setDisable(true);
        mages2B.setDisable(true);
        mages3B.setDisable(true);
        artillery1B.setDisable(true);
        artillery2B.setDisable(true);
        artillery3B.setDisable(true);

        //ring image
        ring1.setOpacity(0);
        ring1.setDisable(true);
        ring2.setOpacity(0);
        ring2.setDisable(true);
        ring3.setOpacity(0);
        ring3.setDisable(true);
    }
    public void move(Raider raider){

        anchor.getChildren().addAll(raider.getImageView());
        anchor.getChildren().addAll(raider.getLabel());
        //raider.getLabel()
        raider.getImageView().setScaleX(0.2);
        raider.getImageView().setScaleY(0.2);
        raider.getImageView().setLayoutX(240);
        raider.getImageView().setLayoutY(60);
        raider.getImageView().setFitHeight(100);
        raider.getImageView().setFitWidth(100);
        raider.getLabel().setLayoutX(240);
        raider.getLabel().setLayoutY(40);
        Path path=new Path();
        path.getElements().add(new MoveTo(0,0));
        path.getElements().add(new CubicCurveTo(15,125,-20,150,-30,150));
        path.getElements().add(new CubicCurveTo(-250,160,-120,240,-140,230));
        path.getElements().add(new CubicCurveTo(15,245,20,240,35,320));

        Path pathLable=new Path();
        pathLable.getElements().add(new MoveTo(0,0));
        pathLable.getElements().add(new CubicCurveTo(15,105,-20,130,-30,130));
        pathLable.getElements().add(new CubicCurveTo(-250,140,-120,220,-140,210));
        pathLable.getElements().add(new CubicCurveTo(15,225,20,220,35,300));

        PathTransition pathT=new PathTransition();
        pathT.setDuration(Duration.millis(30000));
        pathT.setPath(path);

        PathTransition pathT2=new PathTransition();
        pathT2.setDuration(Duration.millis(30000));
        pathT2.setPath(pathLable);

        pathT.setNode(raider.getImageView());
        pathT.setCycleCount(1);
        pathT.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathT.play();

        pathT2.setNode(raider.getLabel());
        pathT2.setCycleCount(1);
        pathT2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathT2.play();

    }

    @Override
    public void run() {
        int i=0;
        while(i<1000){


            checkBoard();

           /* Platform.runLater(()->{
                currentWave.raiders.forEach(entry -> {
                    if (entry.getHealth()==0){
                        entry.getImageView().setImage(null);
                        currentWave.raiders.remove(entry);
                    }else{
                        entry.getImageView().setImage(entry.getImage());

                    }
                });
            });*/
           try{

               towers.forEach(entry -> {
                    entry.shut(currentWave);
               });


               Platform.runLater(()->{
                   currentWave.raiders.forEach(entry -> {
                       entry.setX((int)(entry.getImageView().getLayoutX()+entry.getImageView().getTranslateX()+50));
                       entry.setY((int) (entry.getImageView().getLayoutY()+entry.getImageView().getTranslateY()+50));

                       //entry.getLabel().setText("x="+String.valueOf(Math.round(entry.getImageView().getLayoutX()+entry.getImageView().getTranslateX()))+"\ny="+String.valueOf((Math.round(entry.getImageView().getLayoutY()+entry.getImageView().getTranslateY()))));
                   });
               });
               Thread.sleep(1000);
               i++;
           }catch (Exception e){

               i=10;
           }
        }
    }
    public void checkBoard(){
        life.setText(String.valueOf(level1.getLife()));
        coin.setText(String.valueOf(level1.getCoin()));
        wave.setText(String.valueOf(level1.getWave()+"/4"));
    }
}
