package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.sql.SQLException;

public class Shop {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView wood;
    @FXML
    private Label freezeL;
    @FXML
    private Label healL;
    @FXML
    private Label littleL;
    @FXML
    private Label coinL;
    @FXML
    private Label diamond;
    Image page=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\KRF_ShopMain.png");
    Image woodI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\pngtree-wooden-panel-for-game-ui-in-cartoon-style-png-image_9560501.png");

    public void initialize(){
        coinL.setText(String.valueOf(Player.getPlayer().coinSpell));
        healL.setText(String.valueOf(Player.getPlayer().healSpell));
        freezeL.setText(String.valueOf(Player.getPlayer().freezeSpell));
        littleL.setText(String.valueOf(Player.getPlayer().littleSpell));

        imageView.setImage(page);
        wood.setImage(woodI);
        diamond.setText(String.valueOf(Player.getPlayer().getDiamond()));
    }
    public void setHomeB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void buyCoin() throws SQLException {
        if (Player.getPlayer().getDiamond()>= Coin.getPrice()){
            Player.getPlayer().coinSpell++;
            int diamond=Player.getPlayer().getDiamond();
            diamond-=Coin.getPrice();
            Player.getPlayer().setDiamond(diamond);
            this.diamond.setText(String.valueOf(Player.getPlayer().getDiamond()));
            coinL.setText(String.valueOf(Player.getPlayer().coinSpell));
            int result= Session.database.executeQueryWithoutResult("UPDATE player SET diamond = '" +Player.getPlayer().getDiamond()+ "' , coinSpell = '" +Player.getPlayer().coinSpell+ "'  WHERE id = " +Player.getPlayer().getId()+ ";");
        }
    }
    public void buyHeal() throws SQLException {
        if (Player.getPlayer().getDiamond()>= Heal.getPrice()){
            Player.getPlayer().healSpell++;
            int diamond=Player.getPlayer().getDiamond();
            diamond-=Heal.getPrice();
            Player.getPlayer().setDiamond(diamond);
            this.diamond.setText(String.valueOf(Player.getPlayer().getDiamond()));
            healL.setText(String.valueOf(Player.getPlayer().healSpell));
            int result= Session.database.executeQueryWithoutResult("UPDATE player SET diamond = '" +Player.getPlayer().getDiamond()+ "' , healSpell = '" +Player.getPlayer().healSpell+ "'  WHERE id = " +Player.getPlayer().getId()+ ";");
        }

    }
    public void buyFreeze() throws SQLException {
        if (Player.getPlayer().getDiamond()>= Freeze.getPrice()){
            Player.getPlayer().freezeSpell++;
            int diamond=Player.getPlayer().getDiamond();
            diamond-=Freeze.getPrice();
            Player.getPlayer().setDiamond(diamond);
            this.diamond.setText(String.valueOf(Player.getPlayer().getDiamond()));
            freezeL.setText(String.valueOf(Player.getPlayer().freezeSpell));
            int result= Session.database.executeQueryWithoutResult("UPDATE player SET diamond = '" +Player.getPlayer().getDiamond()+ "' , freezeSpell = '" +Player.getPlayer().freezeSpell+ "'  WHERE id = " +Player.getPlayer().getId()+ ";");
        }

    }
    public void buyLittle() throws SQLException {
        if (Player.getPlayer().getDiamond()>= LittleBoy.getPrice()){
            Player.getPlayer().littleSpell++;
            int diamond=Player.getPlayer().getDiamond();
            diamond-=LittleBoy.getPrice();
            Player.getPlayer().setDiamond(diamond);
            this.diamond.setText(String.valueOf(Player.getPlayer().getDiamond()));
            littleL.setText(String.valueOf(Player.getPlayer().littleSpell));
            int result= Session.database.executeQueryWithoutResult("UPDATE player SET diamond = '" +Player.getPlayer().getDiamond()+ "' , littleSpell = '" +Player.getPlayer().littleSpell+ "'  WHERE id = " +Player.getPlayer().getId()+ ";");
        }

    }
}
