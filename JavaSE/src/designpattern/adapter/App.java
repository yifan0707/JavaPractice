package designpattern.adapter;

/**
 * Adapter design pattern allows two incompatible interfaces to work together
 *
 * Notice! Any class can work together as long as the adapter solves the issue
 * that all classes mush implement every method defined by the shared interface
 *
 * In this case, both adult and infant have the same functionality. However,
 * they have different method name. So InfantAdapter class is created that
 * pass in instance of the Infants and rewrite the GrownUps interface using
 * existing methods
 *
 */
public class App {
    public static void main(String[] args){
        GrownUps adult1=new Adult();
        InfantsAdapter infant1=new InfantsAdapter(new Infants());

        adult1.humanEat();
        adult1.humanPlay();
        adult1.humanWalk();
        System.out.println("\n");

        infant1.humanEat();
        infant1.humanPlay();
        infant1.humanWalk();
    }
}
