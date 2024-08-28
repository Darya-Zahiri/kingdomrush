package model;

import javafx.scene.image.Image;

public class Archer extends Tower {
    //این برج قابلیت حمله به نیروهای هوایی و زمینی را دارد و در هر لحظه تنها
    //یک مهاجم را �ی تواند هدف قرار دهد. قدرت تخریب آن برای مهاجمهای سپردار
    //نصف محاسبه �یشود.
    public Archer() {
        super(1, 70, 80);
    }
    private Image imag=new Image("C:\\Users\\zam zam\\Pictures\\Saved Pictures\\archer.png");

    public Image getImag() {
        return imag;
    }
}
