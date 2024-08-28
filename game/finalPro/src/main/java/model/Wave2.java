package model;

public class Wave2 extends  Wave{
    public Wave2(){
        count=2;
        for (int i=0;i<4;i++){
            Ghost ghost=new Ghost();
            raiders.add(ghost);
        }
        for (int i=0;i<2;i++){
            Zombie zombie=new Zombie();
            raiders.add(zombie);
        }
    }
}
