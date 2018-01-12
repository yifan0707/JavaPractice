package designpattern.strategy;

public class CompactCar extends Car {
    public CompactCar(){
        refuelType=new PetrolRefuel();
    }
}
