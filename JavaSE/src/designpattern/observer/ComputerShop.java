package designpattern.observer;

import java.util.ArrayList;
import java.util.HashMap;

public class ComputerShop implements Subject {
    private ArrayList<Observer> observers;
    private HashMap<MerchandiseName,Integer> items;

    public ComputerShop(){
        observers=new ArrayList<>();
        items=new HashMap<>();
        initialStock();
    }

    public void initialStock(){
        items.put(MerchandiseName.IBN5100,1);
        items.put(MerchandiseName.IPHONEX,10);
        items.put(MerchandiseName.OPPOR11,20);
    }

    public synchronized void addingMerchandise(MerchandiseName name,Integer count){
        if(items.containsKey(name)){
            items.replace(name,items.get(name)+count);
        }else{
            items.put(name,count);
        }

        notifyObserver();
    }

    public synchronized void sellingMerchandise(MerchandiseName name,Integer count){
        if(items.containsKey(name)&&items.get(name)>=count){
            items.replace(name,items.get(name)-count);
        }
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        if(observers.remove(o)){
            System.out.println("The given observer removed");
        }else{
            System.out.println("Given observer not found");
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer o:observers){
            o.update(items);
        }
    }
}

