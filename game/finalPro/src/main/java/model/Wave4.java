package model;

public class Wave4 extends Wave{
    public Wave4() {
        count = 4;
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
        for (int i = 0; i < 2; i++) {
            Crab crab = new Crab();
            raiders.add(crab);
        }
    }
}
