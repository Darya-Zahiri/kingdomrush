package model;

public interface Heal extends Spell {
    public static int getPrice() {
        return 350;
    }

    @Override
    public default void dropMap(Map level) {
        int health= level.getLife();
        health+=5;
        level.setLife(health);
    }

    @Override
    public default void dropWave(Wave currentWave) {

    }
}
