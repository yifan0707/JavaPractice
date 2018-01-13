package designpattern.observer;

/**
 * Observer design pattern is strongly used in the situation that when something
 * changed within one class, many other classes will change with it.
 *
 * Observer design pattern will offer a loose coupling relationship between
 * subject and observers. Since the subject literally doesnt have to know
 * anything of the observers
 *
 * Negatives: The subject may send updates that doesnt matter to the observer
 *
 * In order to implementing observer design pattern.
 * 1. Creating interface for subjects(registerObserver,unregisterObserver,notify)
 * and Observers(update)
 * 2. Subject class needs to implementing the corresponding interface and
 * store the observers as an arraylist
 * 3. Observer class needs to rewrite the interface method and other functionality
 * At the same time, register itself to the subject in the constructor
 *
 *
 */
public class App {
    public static void main(String[] args){
        ComputerShop computerShop=new ComputerShop();
        Observer observer=new ItemObserver(computerShop);

        computerShop.sellingMerchandise(MerchandiseName.IBN5100,1);

        computerShop.addingMerchandise(MerchandiseName.IBN5100,3);

        computerShop.sellingMerchandise(MerchandiseName.IBN5100,1);

        StockControl stockControl=new StockControl(computerShop);
        new Thread(stockControl).start();
        new Thread(stockControl).start();
    }
}
