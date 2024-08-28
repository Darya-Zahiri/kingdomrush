package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Player;

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
    private Image map=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\kingdom_rush_1072_premium_5.jpg");
    private Image sheild=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\newq2.png");
    private Image star=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\star.png");

    public void initialize(){
        page.setImage(map);
        sheild1.setImage(sheild);
        sheild2.setImage(sheild);
        sheild3.setImage(sheild);
        sheild4.setImage(sheild);
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
    public void setLevel2(ActionEvent event){
    }
}
