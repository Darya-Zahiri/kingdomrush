package model;

public class Wave5 extends Wave{
    public Wave5() {
        count = 4;
        for (int i = 0; i < 2; i++) {
            Ghost ghost = new Ghost();
            raiders.add(ghost);
        }
        for (int i = 0; i < 2; i++) {
            Zombie zombie = new Zombie();
            raiders.add(zombie);
        }
        for (int i = 0; i < 3; i++) {
            Troll troll = new Troll();
            raiders.add(troll);
        }
        for (int i = 0; i < 3; i++) {
            Crab crab = new Crab();
            raiders.add(crab);
        }
    }
}
