package designpattern.strategy;

import java.time.Year;

public class Car {
    private String type;
    private String brand;
    private int width;
    private int height;
    private Year yearMade;
    private float price;

    //refuel: 1. petrol 2. Diesel fuel 3. electricity
    protected Refuel refuelType;

    public void setRefuelType(Refuel newRefuelType){
        this.refuelType=newRefuelType;
    }

    public void refuel(){
        refuelType.refuel();
    }
}
