package model;

import javafx.scene.image.Image;

public class Barracks extends Tower{

    public Barracks() {
        super(20, 70, 100);
    }
    private Image imag=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\barracks.png");

    public Image getImag() {
        return imag;
    }
}
