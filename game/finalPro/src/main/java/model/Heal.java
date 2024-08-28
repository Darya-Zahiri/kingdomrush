package model;

public interface Heal extends Spell {
    public static int getPrice() {
        return 350;
    }


    public static void dropMap(Map level) {
        int health= level.getLife();
        health+=5;
        level.setLife(health);
    }


    public static void dropWave(Wave currentWave) {

    }
}
