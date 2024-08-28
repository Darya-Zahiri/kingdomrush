package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Player;
import model.Session;

import java.io.IOException;
import java.sql.SQLException;

public class Setting {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Label error;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button homeB;
    @FXML
    private Button voiceB;
    @FXML
    private Button change;
    @FXML
    private ImageView page;
    @FXML
    private ImageView home;
    @FXML
    private ImageView voice;
    @FXML
    private ImageView mark;
    private Image pageI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\13.png");
    private Image homeI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\home.png");
    private Image wood=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\pngtree-wooden-panel-for-game-ui-in-cartoon-style-png-image_9560501.png");
    private Image voiceOnI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\voiceon.png");
    private Image voiceOffI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\voiceoff.png");

    public void initialize(){
        page.setImage(pageI);
        home.setImage(homeI);
        if (Player.getPlayer().audio){
            voice.setImage(voiceOnI);
        }else {
            voice.setImage(voiceOffI);
        }
        mark.setImage(wood);
    }

    public void setHomeB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setVoiceB(ActionEvent event){
        if (Player.getPlayer().audio){
            Player.getPlayer().mediaPlayer.pause();
            Player.getPlayer().audio=false;
            voice.setImage(voiceOffI);
        }else {
            Player.getPlayer().audio=true;
            Player.getPlayer().mediaPlayer.play();
            voice.setImage(voiceOnI);
        }
    }
    public void setChange() {
        error.setText("");
        error.setTextFill(Color.RED);
        if (validateInput(username.getText(),password.getText())){
            try {
                int result = Session.database.executeQueryWithoutResult("UPDATE player SET username = '" + username.getText() + "' , password = '" + password.getText() + "' WHERE id = " + Player.getPlayer().getId() + ";");
                error.setTextFill(Color.GREEN);
                error.setText("done");
            }catch (SQLException e){
                error.setText("username already taken");
            }
        }
    }
    public boolean validateInput(String username,String first){

        if (username.isEmpty()){
            this.username.requestFocus();
            error.setText("username is empty");
            return false;
        }
        if (first.isEmpty()){
            this.password.requestFocus();
            error.setText("password is empty");
            return false;
        }
        if (first.length()<6){
            this.password.requestFocus();
            error.setText("password should be longer");
            return false;
        }
        return true;
    }
}
