package model;

public interface Coin extends Spell {
    public static int getPrice() {
        return 850;
    }


    public static void dropMap(Map level) {
        int coin=level.getCoin();
        coin+=200;
        level.setCoin(coin);
    }

    public static void dropWave(Wave currentWave) {

    }
}
