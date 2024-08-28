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

public class Signin {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView signin;
    @FXML
    private ImageView signup;
    @FXML
    private Label error;
    @FXML
    private Button signU;
    @FXML
    private Button signI;
    private Image image=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\sign.jpg");
    private Image wood=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\pngtree-wooden-panel-for-game-ui-in-cartoon-style-png-image_9560501.png");

    public void initialize(){
        imageView.setImage(image);
        signin.setImage(wood);
        signup.setImage(wood);
    }

    public boolean validateInput(String username,String password){
        if (username.isEmpty()){
            this.username.requestFocus();
            error.setText("username is empty");
            return false;
        }
        if (password.isEmpty()){
            this.password.requestFocus();
            error.setText("password is empty");
            return false;
        }
        if (password.length()<6){
            this.password.requestFocus();
            error.setText("password should be longer");
            return false;
        }
        return true;
    }

    public void setSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/signup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setSignIn(ActionEvent event) throws IOException, SQLException {
        error.setText("");
        if (validateInput(username.getText(),password.getText())){
           error.setText(Player.getPlayer().signIn(username.getText(),password.getText()));
        }
        if (error.getText().equals("user found")){
            root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
