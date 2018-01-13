package designpattern.observer;

import java.util.HashMap;

public class ItemObserver implements Observer {
    private ComputerShop cs;
    private static int observerID;

    public ItemObserver(ComputerShop cs){
        ++observerID;
        this.cs=cs;
        this.cs.registerObserver(this);
    }

    @Override
    public void update(HashMap<MerchandiseName,Integer> map) {
        for(MerchandiseName name:map.keySet()){
            int itemRemains=map.get(name);
            if(itemRemains>0){
                System.out.println("Item "+name+" has "+itemRemains+" remains.");
            }else{
                System.out.println("Item "+name+" has run out of stock.");
            }
        }
        System.out.println("\n");
    }
}
