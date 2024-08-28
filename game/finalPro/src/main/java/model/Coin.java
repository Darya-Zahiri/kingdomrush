package model;

public interface Coin extends Spell {
    public static int getPrice() {
        return 850;
    }

    @Override
    public default void dropMap(Map level) {
        int coin=level.getCoin();
        coin+=200;
        level.setCoin(coin);
    }

    @Override
    public default void dropWave(Wave currentWave) {

    }
}
