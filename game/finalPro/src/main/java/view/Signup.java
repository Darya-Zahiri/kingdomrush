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
import javafx.stage.Stage;
import model.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Signup {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private ImageView back;
    @FXML
    private Button backB;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repassword;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView signin;
    @FXML
    private Label error;
    @FXML
    private Button signU;
    private Image image=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\sign.jpg");
    private Image wood=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\pngtree-wooden-panel-for-game-ui-in-cartoon-style-png-image_9560501.png");
    private Image backI=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\back.png");

    public void initialize(){
        back.setImage(backI);
        imageView.setImage(image);
        signin.setImage(wood);
    }

    public boolean validateInput(String username,String first,String second){

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
        if (!first.equals(second)){
            this.repassword.requestFocus();
            error.setText("passwords are not equal");
            return false;
        }
        return true;
    }

    public void setSignUp(ActionEvent event) throws IOException, InterruptedException {
        error.setText("");
        if (validateInput(username.getText(),password.getText(),repassword.getText())){
            error.setText(Player.getPlayer().signup(username.getText(),password.getText()));
        }
        if (Player.status){
            root = FXMLLoader.load(getClass().getResource("/view/signin.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void setBackB(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/signin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
