package designpattern.strategy;

public interface Refuel {
    void refuel();
}
class DieselRefuel implements Refuel{
    public void  refuel(){
        System.out.println("This car use diesel to refuel");
    }
}

class PetrolRefuel implements Refuel{
    public void refuel(){
        System.out.println("This car use petrol to refuel");
    }
}

class ElectricityRefuel implements Refuel{
    public void refuel(){
        System.out.println("This car use electricity to refuel");
    }
}