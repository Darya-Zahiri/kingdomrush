package model;

public interface LittleBoy extends Spell {
    public static int getPrice() {
        return 50;
    }

    @Override
    public default void dropMap(Map level) {

    }

    @Override
    public default void dropWave(Wave currentWave) {
        for (int j=0;j<currentWave.raiders.size();j++){
            if (currentWave.raiders.get(j).getImageView().getOpacity()!=0){
                currentWave.raiders.get(j).status=false;
                currentWave.raiders.get(j).getImageView().setOpacity(0);
            }
        }
    }
}
