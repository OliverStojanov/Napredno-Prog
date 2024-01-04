package Zad62;

import java.util.Random;

public class LoadedCoin extends Coin {
    int probability;
    public LoadedCoin(int probability) {
        super();
        this.probability = probability;
    }

    public SIDE flip() {
        Random random = new Random();
        int isHead = random.nextInt(100);
        if (isHead < probability) {
            return SIDE.HEAD;
        } else {
            return SIDE.TAIL;
        }
    }
}
