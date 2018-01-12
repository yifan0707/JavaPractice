package designpattern.strategy;

public class Truck extends Car{
    public Truck(){
        refuelType=new DieselRefuel();
    }
}
