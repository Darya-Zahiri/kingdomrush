package model;

public interface LittleBoy extends Spell {
    public static int getPrice() {
        return 50;
    }


    public static void dropMap(Map level) {

    }


    public static void dropWave(Wave currentWave) {
        for (int j=0;j<currentWave.raiders.size();j++){
            if (currentWave.raiders.get(j).getImageView().getOpacity()!=0){
                currentWave.raiders.get(j).setHealth(0);

            }
        }
    }
}
