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

import java.io.File;
import java.io.IOException;

public class Lose {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Button ok;
    @FXML
    private ImageView imageView;
    private Image lose=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\lose1.jpg");
    public void initialize(){
        String shoot="C:\\Users\\zam zam\\Downloads\\Game-Over-Sound-Effect-4.mp3";
        Media sound = new Media(new File(shoot).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        imageView.setImage(lose);
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

}
