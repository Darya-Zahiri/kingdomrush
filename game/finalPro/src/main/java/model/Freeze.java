package model;

public interface Freeze extends Spell {
    public static int getPrice() {
        return 250;
    }

    @Override
    public default void dropMap(Map level) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public default void dropWave(Wave currentWave) {

    }
}
