package designpattern.adapter;

import java.util.Random;

public class Adult implements GrownUps {
    @Override
    public void humanWalk() {
        System.out.println("Adult walk "+ (new Random().nextInt(2))
                +"m per second");
    }

    @Override
    public void humanEat() {
        System.out.println("Adult Eat vegetables&meat");
    }

    @Override
    public void humanPlay() {
        System.out.println("Adult go out and play");
    }
}
