package model;

public class Map {
    private int coin;

    private int life;

    private int wave;

    public Map(int coin,int life,int wave) {
        this.coin = coin;
        this.life=life;
        this.wave=wave;
    }

    public int getCoin() {
        return coin;
    }

    public int getLife() {
        return life;
    }

    public int getWave() {
        return wave;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
}
