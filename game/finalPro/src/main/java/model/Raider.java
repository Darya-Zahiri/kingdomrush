package model;

public abstract class Raider {
    private int health;

    private int speed;

    private int loot;

    private int breakPoint;

    public Raider(int health,int speed,int loot,int breakPoint) {
        this.health = health;
        this.speed=speed;
        this.loot=loot;
        this.breakPoint=breakPoint;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLoot() {
        return loot;
    }

    public int getBreakPoint() {
        return breakPoint;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void setBreakPoint(int breakPoint) {
        this.breakPoint = breakPoint;
    }
}
