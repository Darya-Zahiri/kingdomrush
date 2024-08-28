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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.Player;
import model.Session;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Win {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Button ok;
    @FXML
    private ImageView imageView;
    private Image win=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\win1.jpg");
    public void initialize() throws SQLException {
        add();
        String shoot="C:\\Users\\zam zam\\Downloads\\Victory-Sound-Effect.mp3";
        Media sound = new Media(new File(shoot).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        imageView.setImage(win);
    }
    public void gohome(ActionEvent event) throws IOException {
        /*root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();*/
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    public void add() throws SQLException {
        int level= Player.getPlayer().getLevel();
        level++;
        Player.getPlayer().setLevel(level);
        int diamond=Player.getPlayer().getDiamond();
        diamond+=500;
        Player.getPlayer().setDiamond(diamond);
        int result= Session.database.executeQueryWithoutResult("UPDATE player SET diamond = '" +Player.getPlayer().getDiamond()+ "' , level = '" +Player.getPlayer().getLevel()+ "'  WHERE id = " +Player.getPlayer().getId()+ ";");
    }
}
