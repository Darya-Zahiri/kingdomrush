package model;

public class Wave3 extends Wave{
    public Wave3() {
        count = 3;
        for (int i = 0; i < 2; i++) {
            Ghost ghost = new Ghost();
            raiders.add(ghost);
        }
        for (int i = 0; i < 2; i++) {
            Zombie zombie = new Zombie();
            raiders.add(zombie);
        }
        for (int i = 0; i < 2; i++) {
            Troll troll = new Troll();
            raiders.add(troll);
        }
    }
}
