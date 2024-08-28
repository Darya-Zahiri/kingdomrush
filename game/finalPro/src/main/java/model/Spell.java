package model;

public interface Spell {
    static int getPrice() {
        return 0;
    }

    void dropMap(Map level);
    void dropWave(Wave currentWave);
}
