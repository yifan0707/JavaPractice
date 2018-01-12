package designpattern.strategy;

public class ElectricVehicle extends Car{

    public ElectricVehicle(){
        refuelType=new ElectricityRefuel();
    }

}
