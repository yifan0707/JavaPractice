package designpattern.decorator;

/**
 * Decorator design pattern allows client to modify an object dynamically
 * This design pattern is much more flexible than inheritance
 *
 * In this example, a client want to create a new computer.
 * To accomplish this task, he will need to buy multiple things which means
 * the description and the cost would change frequently as the order would
 * change dynamically according to different user needs
 *
 * Thus, if we using a simple inheritance design here, we would need to create
 *  a new class whenever a new combination is created which is too hard to
 *  maintain and far too complex.
 *  So, decoration design pattern is able to solve the problem since it can add
 *  functionality at the runtime of the subclasses.
 *
 */
public class App {
    public static void main(String[] args){
        Computer DIYComputer=new BasicComputer();
        DIYComputer=new CPU(DIYComputer);
        DIYComputer=new GPU(DIYComputer);
        System.out.println(DIYComputer.getComponents());
        System.out.println(DIYComputer.getCost());

        //CPU,GPU are the subclass that extends Decorator
        //Additionally, decorator implements Computer
        //Thus, in this case, we can write the initiation in one line like showed below.
        Computer DIYComputer2=new CPU(new GPU(new BasicComputer()));
        System.out.println(DIYComputer2.getComponents());
        System.out.println(DIYComputer2.getCost());
    }
}
