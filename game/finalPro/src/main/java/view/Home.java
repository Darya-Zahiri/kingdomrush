package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Player;

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
    private Image map=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\kingdom_rush_1072_premium_5.jpg");
    private Image sheild=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\newq2.png");
    private Image star=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\star.png");
    private Image settings=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\settingend.png");
    private Image backI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\back.png");

    public void initialize(){
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
    public void setLevel2(ActionEvent event){
    }
    public void setBackB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/signin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
