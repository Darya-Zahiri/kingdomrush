package model;

import javafx.scene.image.Image;

public class Mages extends Tower{
    public Mages() {
        super(2, 80, 100);
    }
    private Image imag=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\mage.png");

    public Image getImag() {
        return imag;
    }
}
