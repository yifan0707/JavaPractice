package designpattern.adapter;

import java.util.Random;

public class Infants {
    public void infantsCrow() {
        System.out.println("Infants walk "+ (new Random().nextFloat())
                +"m per second");
    }

    public void infantsEat() {
        System.out.println("infants Eat baby food");
    }

    public void infantsPlay() {
        System.out.println("infants kicks their legs");
    }
}
