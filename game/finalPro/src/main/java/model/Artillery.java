package model;

import javafx.scene.image.Image;

public class Artillery extends Tower{

    public Artillery() {
        super(20, 70, 10);
    }
    private Image imag=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\artillery.png");

    public Image getImag() {
        return imag;
    }
}
