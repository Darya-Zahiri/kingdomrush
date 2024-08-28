package view;

import controller.HelloApplication;
import javafx.animation.PathTransition;
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
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;

import javax.print.attribute.standard.Media;
import java.io.IOException;
import java.util.ArrayList;

public class Level4 implements Runnable{
    Stage stage;
    Scene scene;
    Parent root;
    Boolean live=true;
    public ArrayList<Tower> towers=new ArrayList<>();
    @FXML
    private AnchorPane anchor;
    @FXML
    private ImageView home;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView tower1;
    @FXML
    private ImageView tower2;
    @FXML
    private ImageView tower3;
    @FXML
    private ImageView tower4;
    @FXML
    private ImageView tower5;
    @FXML
    private Button tower1B;
    @FXML
    private Button tower2B;
    @FXML
    private Button tower3B;
    @FXML
    private Button tower4B;
    @FXML
    private Button tower5B;
    @FXML
    private ImageView ring1;
    @FXML
    private ImageView ring2;
    @FXML
    private ImageView ring3;
    @FXML
    private ImageView ring4;
    @FXML
    private ImageView ring5;
    @FXML
    private ImageView board;
    @FXML
    private Label life;
    @FXML
    private Label coin;
    @FXML
    private Label wave;
    @FXML
    private Button archer1B;
    @FXML
    private Button archer2B;
    @FXML
    private Button archer3B;
    @FXML
    private Button archer4B;
    @FXML
    private Button archer5B;
    @FXML
    private Button barracks1B;
    @FXML
    private Button barracks2B;
    @FXML
    private Button barracks3B;
    @FXML
    private Button barracks4B;
    @FXML
    private Button barracks5B;
    @FXML
    private Button mages1B;
    @FXML
    private Button mages2B;
    @FXML
    private Button mages3B;
    @FXML
    private Button mages4B;
    @FXML
    private Button mages5B;
    @FXML
    private Button artillery1B;
    @FXML
    private Button artillery2B;
    @FXML
    private Button artillery3B;
    @FXML
    private Button artillery4B;
    @FXML
    private Button artillery5B;
    @FXML
    private ImageView attack;


    private Image map4=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\map3.png");
    private Image homeI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\home.png");
    private Image towerI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\towerplace.png");
    private Image boardI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\board.png");
    private Image ringI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\ring.png");
    private Image upgrade=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\upgrade.png");
    private Image attackI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\start1.png");

    Map level4=new Map(300,10,0);
    Wave currentWave=new Wave();
    public int waveCount=0;
    public void initialize(){
        disable();
        attack.setImage(attackI);
        board.setImage(boardI);
        ring1.setImage(ringI);
        ring2.setImage(ringI);
        ring3.setImage(ringI);
        ring4.setImage(ringI);
        ring5.setImage(ringI);
        tower1.setImage(towerI);
        tower2.setImage(towerI);
        tower3.setImage(towerI);
        tower4.setImage(towerI);
        tower5.setImage(towerI);
        home.setImage(homeI);
        imageView.setImage(map4);
        Thread thread = new Thread(this);
        thread.start();
    }
    public void disable(){
        //tower Buttons
        archer1B.setDisable(true);
        archer2B.setDisable(true);
        archer3B.setDisable(true);
        archer4B.setDisable(true);
        archer5B.setDisable(true);
        barracks1B.setDisable(true);
        barracks2B.setDisable(true);
        barracks3B.setDisable(true);
        barracks4B.setDisable(true);
        barracks5B.setDisable(true);
        mages1B.setDisable(true);
        mages2B.setDisable(true);
        mages3B.setDisable(true);
        mages4B.setDisable(true);
        mages5B.setDisable(true);
        artillery1B.setDisable(true);
        artillery2B.setDisable(true);
        artillery3B.setDisable(true);
        artillery4B.setDisable(true);
        artillery5B.setDisable(true);

        //ring image
        ring1.setOpacity(0);
        ring1.setDisable(true);
        ring2.setOpacity(0);
        ring2.setDisable(true);
        ring3.setOpacity(0);
        ring3.setDisable(true);
        ring4.setOpacity(0);
        ring4.setDisable(true);
        ring5.setOpacity(0);
        ring5.setDisable(true);
    }
    public void click(ActionEvent event){
        switch (waveCount){
            case 0:
                level4.setWave(1);
                currentWave = new wave1();
                waveCount++;
                break;

            case 1:
                level4.setWave(2);
                currentWave = new Wave2();
                waveCount++;
                break;
            case 2:

                level4.setWave(3);
                currentWave = new Wave3();
                waveCount++;
                break;
            case 3:

                level4.setWave(4);
                currentWave = new Wave4();
                waveCount++;
                break;
            case 4:

                level4.setWave(5);
                currentWave = new Wave5();
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
            //ring1.setLayoutY(40);
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
    public void setTower4B(){
        disable();
        if (tower4.getImage().equals(towerI)){
            ring4.setOpacity(1);
            archer4B.setDisable(false);
            barracks4B.setDisable(false);
            mages4B.setDisable(false);
            artillery4B.setDisable(false);
        }else {
            ring4.setImage(upgrade);
            ring4.setOpacity(1);
            //ring1.setLayoutY(40);
        }
    }
    public void setTower5B(){
        disable();
        if (tower5.getImage().equals(towerI)){
            ring5.setOpacity(1);
            archer5B.setDisable(false);
            barracks5B.setDisable(false);
            mages5B.setDisable(false);
            artillery5B.setDisable(false);
        }else {
            ring5.setImage(upgrade);
            ring5.setOpacity(1);
            //ring1.setLayoutY(40);
        }
    }
    public void setArcher1B(){
        disable();
        Archer archer=new Archer();
        tower1.setImage(archer.getImag());
        //tower1.setLayoutX(155);
        archer.setX((int) (tower1.getLayoutX()+65));
        archer.setY((int) (tower1.getLayoutY()+32));
        towers.add(archer);
        int cost=level4.getCoin();
        cost-=archer.getCost();
        level4.setCoin(cost);
    }
    public void setBarracks1B(){
        disable();
        Barracks barracks=new Barracks();
        //tower1.setImage(barracks.getImag());
        //tower1.setLayoutX(155);
        barracks.setX((int) (tower1.getLayoutX()+65));
        barracks.setY((int) (tower1.getLayoutY()+32));
        towers.add(barracks);

        int cost=level4.getCoin();
        cost-=barracks.getCost();
        level4.setCoin(cost);
    }
    public void setMages1B(){
        disable();
        Mages mages=new Mages();
        //tower1.setImage(mages.getImag());
        //tower1.setLayoutX(155);
        mages.setX((int) (tower1.getLayoutX()+65));
        mages.setY((int) (tower1.getLayoutY()+32));
        towers.add(mages);

        int cost=level4.getCoin();
        cost-=mages.getCost();
        level4.setCoin(cost);
    }
    public void setArtillery1B(){
        disable();
        Artillery artillery=new Artillery();
        //tower1.setImage(artillery.getImag());
        //tower1.setLayoutX(155);
        artillery.setX((int) (tower1.getLayoutX()+65));
        artillery.setY((int) (tower1.getLayoutY()+32));
        towers.add(artillery);

        int cost=level4.getCoin();
        cost-=artillery.getCost();
        level4.setCoin(cost);
    }


    public void setArcher2B(){
        disable();
        Archer archer=new Archer();
        //tower2.setImage(archer.getImag());
        //tower2.setLayoutX(225);
        archer.setX((int) (tower2.getLayoutX()+65));
        archer.setY((int) (tower2.getLayoutY()+32));
        towers.add(archer);

        int cost=level4.getCoin();
        cost-=archer.getCost();
        level4.setCoin(cost);
    }
    public void setBarracks2B(){
        disable();
        Barracks barracks=new Barracks();
        tower2.setImage(barracks.getImag());
        //tower2.setLayoutX(225);
        //tower2.setLayoutY(240);
        barracks.setX((int) (tower2.getLayoutX()+65));
        barracks.setY((int) (tower2.getLayoutY()+32));
        towers.add(barracks);

        int cost=level4.getCoin();
        cost-=barracks.getCost();
        level4.setCoin(cost);
    }
    public void setMages2B(){
        disable();
        Mages mages=new Mages();
        tower2.setImage(mages.getImag());
        //tower2.setLayoutX(225);
        //tower2.setLayoutY(235);
        mages.setX((int) (tower2.getLayoutX()+65));
        mages.setY((int) (tower2.getLayoutY()+32));
        towers.add(mages);

        int cost=level4.getCoin();
        cost-=mages.getCost();
        level4.setCoin(cost);
    }
    public void setArtillery2B(){
        disable();
        Artillery artillery=new Artillery();
        tower2.setImage(artillery.getImag());
        //tower2.setLayoutX(225);
        //tower2.setLayoutY(235);
        artillery.setX((int) (tower2.getLayoutX()+65));
        artillery.setY((int) (tower2.getLayoutY()+32));
        towers.add(artillery);

        int cost=level4.getCoin();
        cost-=artillery.getCost();
        level4.setCoin(cost);
    }

    public void setArcher3B(){
        disable();
        Archer archer=new Archer();
        tower3.setImage(archer.getImag());
        //tower3.setLayoutX(85);
        archer.setX((int) (tower3.getLayoutX()+65));
        archer.setY((int) (tower3.getLayoutY()+32));
        towers.add(archer);

        int cost=level4.getCoin();
        cost-=archer.getCost();
        level4.setCoin(cost);
    }
    public void setBarracks3B(){
        disable();
        Barracks barracks=new Barracks();
        tower3.setImage(barracks.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        barracks.setX((int) (tower3.getLayoutX()+65));
        barracks.setY((int) (tower3.getLayoutY()+32));
        towers.add(barracks);

        int cost=level4.getCoin();
        cost-=barracks.getCost();
        level4.setCoin(cost);
    }
    public void setMages3B(){
        disable();
        Mages mages=new Mages();
        tower3.setImage(mages.getImag());
        //tower3.setLayoutX(85);
        mages.setX((int) (tower3.getLayoutX()+65));
        mages.setY((int) (tower3.getLayoutY()+32));
        towers.add(mages);

        int cost=level4.getCoin();
        cost-=mages.getCost();
        level4.setCoin(cost);
    }
    public void setArtillery3B(){
        disable();
        Artillery artillery=new Artillery();
        tower3.setImage(artillery.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        artillery.setX((int) (tower3.getLayoutX()+65));
        artillery.setY((int) (tower3.getLayoutY()+32));
        towers.add(artillery);

        int cost=level4.getCoin();
        cost-=artillery.getCost();
        level4.setCoin(cost);
    }
    public void setArcher4B(){
        disable();
        Archer archer=new Archer();
        tower4.setImage(archer.getImag());
        //tower3.setLayoutX(85);
        archer.setX((int) (tower4.getLayoutX()+65));
        archer.setY((int) (tower4.getLayoutY()+32));
        towers.add(archer);

        int cost=level4.getCoin();
        cost-=archer.getCost();
        level4.setCoin(cost);
    }
    public void setBarracks4B(){
        disable();
        Barracks barracks=new Barracks();
        tower4.setImage(barracks.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        barracks.setX((int) (tower4.getLayoutX()+65));
        barracks.setY((int) (tower4.getLayoutY()+32));
        towers.add(barracks);

        int cost=level4.getCoin();
        cost-=barracks.getCost();
        level4.setCoin(cost);
    }
    public void setMages4B(){
        disable();
        Mages mages=new Mages();
        tower4.setImage(mages.getImag());
        //tower3.setLayoutX(85);
        mages.setX((int) (tower4.getLayoutX()+65));
        mages.setY((int) (tower4.getLayoutY()+32));
        towers.add(mages);

        int cost=level4.getCoin();
        cost-=mages.getCost();
        level4.setCoin(cost);
    }
    public void setArtillery4B(){
        disable();
        Artillery artillery=new Artillery();
        tower4.setImage(artillery.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        artillery.setX((int) (tower4.getLayoutX()+65));
        artillery.setY((int) (tower4.getLayoutY()+32));
        towers.add(artillery);

        int cost=level4.getCoin();
        cost-=artillery.getCost();
        level4.setCoin(cost);
    }
    public void setArcher5B(){
        disable();
        Archer archer=new Archer();
        tower5.setImage(archer.getImag());
        //tower3.setLayoutX(85);
        archer.setX((int) (tower5.getLayoutX()+65));
        archer.setY((int) (tower5.getLayoutY()+32));
        towers.add(archer);

        int cost=level4.getCoin();
        cost-=archer.getCost();
        level4.setCoin(cost);
    }
    public void setBarracks5B(){
        disable();
        Barracks barracks=new Barracks();
        tower5.setImage(barracks.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        barracks.setX((int) (tower5.getLayoutX()+65));
        barracks.setY((int) (tower5.getLayoutY()+32));
        towers.add(barracks);

        int cost=level4.getCoin();
        cost-=barracks.getCost();
        level4.setCoin(cost);
    }
    public void setMages5B(){
        disable();
        Mages mages=new Mages();
        tower5.setImage(mages.getImag());
        //tower3.setLayoutX(85);
        mages.setX((int) (tower5.getLayoutX()+65));
        mages.setY((int) (tower5.getLayoutY()+32));
        towers.add(mages);

        int cost=level4.getCoin();
        cost-=mages.getCost();
        level4.setCoin(cost);
    }
    public void setArtillery5B(){
        disable();
        Artillery artillery=new Artillery();
        tower5.setImage(artillery.getImag());
        //tower3.setLayoutX(85);
        //tower3.setLayoutY(316);
        artillery.setX((int) (tower5.getLayoutX()+65));
        artillery.setY((int) (tower5.getLayoutY()+32));
        towers.add(artillery);

        int cost=level4.getCoin();
        cost-=artillery.getCost();
        level4.setCoin(cost);
    }
    public void move(Raider raider){

        anchor.getChildren().addAll(raider.getImageView());
        anchor.getChildren().addAll(raider.getLabel());
        //raider.getLabel()
        raider.getImageView().setScaleX(0.2);
        raider.getImageView().setScaleY(0.2);
        raider.getImageView().setLayoutX(220);
        raider.getImageView().setLayoutY(0);
        raider.getImageView().setFitHeight(100);
        raider.getImageView().setFitWidth(100);

        Path path1=new Path();
        path1.getElements().add(new MoveTo(0,0));
        path1.getElements().add(new CubicCurveTo(0,65,-60,65,-120,65));
        path1.getElements().add(new CubicCurveTo(-165,85,-160,150,-100,150));
        path1.getElements().add(new CubicCurveTo(170,150,200,145,170,230));
        path1.getElements().add(new CubicCurveTo(70,280,10,335,240,340));

        Path path2=new Path();
        path2.getElements().add(new MoveTo(0,0));
        path2.getElements().add(new CubicCurveTo(0,65,-60,65,-120,65));
        path2.getElements().add(new CubicCurveTo(-165,85,-160,150,-100,150));
        path2.getElements().add(new CubicCurveTo(70,150,40,200,10,230));
        path2.getElements().add(new CubicCurveTo(-180,210,-185,320,-220,310));


        PathTransition pathT=new PathTransition();
        pathT.setDuration(Duration.millis(20000));
        pathT.setNode(raider.getImageView());
        pathT.setCycleCount(1);
        pathT.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        if ((waveCount==2)||(waveCount==4)){
            pathT.setPath(path2);
        }else {
            pathT.setPath(path1);
        }
        pathT.play();
    }


    @Override
    public void run() {
        while(live){
            try{
                checklife();
                Platform.runLater(()->{
                    settingImage();
                    checkBoard();
                    towers.forEach(entry -> {
                        if (!currentWave.raiders.isEmpty()){
                            entry.shut(currentWave);}
                    });
                    currentWave.raiders.forEach(entry -> {
                        //System.out.println("x="+entry.getImageView().getTranslateX());
                        //System.out.println("y="+entry.getImageView().getTranslateY());
                        entry.setX((int)(entry.getImageView().getLayoutX()+entry.getImageView().getTranslateX()+50));
                        entry.setY((int) (entry.getImageView().getLayoutY()+entry.getImageView().getTranslateY()+50));
                    });
                });
                Thread.sleep(1000);
            }catch (Exception e){
                live=false;
            }
        }
    }

    public void settingImage(){
        Platform.runLater(()->{
            for (int j=0;j<currentWave.raiders.size();j++){
                if (currentWave.raiders.get(j).getHealth()==0){
                    if (currentWave.raiders.get(j).getImageView().getOpacity()!=0){
                        int cost=level4.getCoin();
                        cost+=currentWave.raiders.get(j).getLoot();
                        level4.setCoin(cost);
                        currentWave.raiders.get(j).status=false;
                        currentWave.raiders.get(j).getImageView().setOpacity(0);
                    }else {
                    }
                }else{
                    currentWave.raiders.get(j).getImageView().setImage(currentWave.raiders.get(j).getImage());

                }
            }
        });
    }
    public void checkBoard(){
        checkend();
        Platform.runLater(()->{
            life.setText(String.valueOf(level4.getLife()));
            coin.setText(String.valueOf(level4.getCoin()));
            wave.setText(level4.getWave()+"/5");
        });
    }
    public void checkend(){
        for (int j=0;j<currentWave.raiders.size();j++){
            if (currentWave.raiders.get(j).getImageView().getTranslateX()>149){
                if (currentWave.raiders.get(j).getImageView().getTranslateY()>198) {
                    if (currentWave.raiders.get(j).status){
                        int life=level4.getLife();
                        life--;
                        level4.setLife(life);
                        currentWave.raiders.get(j).status=false;
                    }
                }
            }
        }
    }
    public void checklife()  {
        if (level4.getLife()==0){

            live = false;
            Platform.runLater(()->{
                try {
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("/view/lose.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setAlwaysOnTop(true);
                    stage.show();
                }catch (Exception e){
                    System.out.println("error");
                }
            });

        }
    }
}

