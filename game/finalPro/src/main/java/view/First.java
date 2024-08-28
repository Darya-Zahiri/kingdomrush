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

import java.io.IOException;

public class First {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private Button start;
    @FXML
    private ImageView imageView;
    private Image image=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\screen_01.jpg");

    public void initialize(){
        imageView.setImage(image);
    }
    public void setStart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/view/signin.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
