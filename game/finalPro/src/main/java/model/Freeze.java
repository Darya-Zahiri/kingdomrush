package model;

public interface Freeze extends Spell {
    public static int getPrice() {
        return 250;
    }


    public static void dropMap(Map level) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void dropWave(Wave currentWave) {

    }
}
