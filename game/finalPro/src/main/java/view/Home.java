package view;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Player;

import java.io.File;
import java.io.IOException;

public class Home {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Button level1;
    @FXML
    private Button level2;
    @FXML
    private Button level3;
    @FXML
    private Button level4;
    @FXML
    private Button settin;
    @FXML
    private ImageView star1;
    @FXML
    private ImageView star2;
    @FXML
    private ImageView star3;
    @FXML
    private ImageView star4;
    @FXML
    private ImageView sheild1;
    @FXML
    private ImageView sheild2;
    @FXML
    private ImageView sheild3;
    @FXML
    private ImageView sheild4;
    @FXML
    private ImageView page;
    @FXML
    private ImageView setting;
    @FXML
    private ImageView back;
    @FXML
    private Button backB;
    @FXML
    private ImageView shop;
    @FXML
    private ImageView diamond;
    @FXML
    private ImageView wood1;
    @FXML
    private ImageView wood2;
    @FXML
    private Label diamondL;
    private Image map=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\kingdom_rush_1072_premium_5.jpg");
    private Image sheild=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\newq2.png");
    private Image star=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\star.png");
    private Image settings=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\settingend.png");
    private Image backI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\back.png");
    private Image diamondI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\diamond.png");
    private Image shopI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\shop.png");
    private Image wood=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\pngtree-wooden-panel-for-game-ui-in-cartoon-style-png-image_9560501.png");

    public void initialize(){
        if (Player.getPlayer().audio){
            Player.getPlayer().mediaPlayer.play();
        }else {
            Player.getPlayer().mediaPlayer.pause();
        }
        wood1.setImage(wood);
        wood2.setImage(wood);
        diamondL.setText(String.valueOf(Player.getPlayer().getDiamond()));
        diamond.setImage(diamondI);
        shop.setImage(shopI);
        back.setImage(backI);
        page.setImage(map);
        sheild1.setImage(sheild);
        sheild2.setImage(sheild);
        sheild3.setImage(sheild);
        sheild4.setImage(sheild);
        setting.setImage(settings);
        switch (Player.getPlayer().getLevel()){
            case 1:
                level2.setDisable(true);
                level3.setDisable(true);
                level4.setDisable(true);
                break;
            case 2:
                level3.setDisable(true);
                level4.setDisable(true);
                star1.setImage(star);
                break;
            case 3:
                level4.setDisable(true);
                star1.setImage(star);
                star2.setImage(star);
                break;
            case 4:
                star1.setImage(star);
                star2.setImage(star);
                star3.setImage(star);
                break;
            case 5:
                star1.setImage(star);
                star2.setImage(star);
                star3.setImage(star);
                star4.setImage(star);
                break;
        }
    }
    public void setSettin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/setting.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLevel1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/level1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLevel2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/level2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLevel3(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/level3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setLevel4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/level4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setBackB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/signin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setShop(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/shop.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
