package model;

import java.util.ArrayList;

public class wave1 extends Wave{
    public wave1(){
        count=1;
        for (int i=0;i<4;i++){
            Ghost ghost=new Ghost();
            raiders.add(ghost);
        }
    }

}
